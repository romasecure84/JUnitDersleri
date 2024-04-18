package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test05 {
    static WebDriver driver;
    @BeforeClass // Before metoddan ferqli olaraq butun testlerden once bir defe isleyir
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1382, 744));
        driver.manage().window().setPosition(new Point(-8, -8));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @Test
    public void urlTextAssertionTest() throws InterruptedException {
        driver.get("https://www.practicetestautomation.com/practice-test-login/");
        Assert.assertTrue(driver.getCurrentUrl().contains("practice"));
    }
    @Test
    public void titleAssertionTest() throws InterruptedException {
        driver.get("https://google.az");
        Assert.assertTrue(driver.getTitle().contains("Google"));
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(By.id("APjFqb")).isDisplayed());
    }
    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}

package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Test04 {
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
    public void loginTestPractice() throws InterruptedException {
        driver.get("https://www.practicetestautomation.com/practice-test-login/");
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Log out")).click();
    }
    @Test
    public void exceptionsTestPractice() throws InterruptedException {
        Actions actions=new Actions(driver);
        driver.get("https://www.practicetestautomation.com/practice-test-exceptions/");
        driver.findElement(By.xpath("//*[@id='edit_btn']")).click();
        Thread.sleep(2000);
        WebElement inputText=driver.findElement(By.className("input-field"));
        inputText.clear();
        inputText.sendKeys("Burger");
        driver.findElement(By.xpath("//*[@id='save_btn']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='add_btn']")).click();
        Thread.sleep(5000);
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Row 2']")).isDisplayed());
        WebElement inputText2=driver.findElement(By.xpath("(//*[@class='input-field'])[2]"));
        inputText2.sendKeys("Pasta");
        driver.findElement(By.xpath("(//*[@id='save_btn'])[2]")).click();

    }
    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}

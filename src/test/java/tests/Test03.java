package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test03 {
    static WebDriver driver;
    @BeforeClass // Before metoddan ferqli olaraq butun testlerden once bir defe isleyir
    public static void hazirliqEt(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1382, 744));
        driver.manage().window().setPosition(new Point(-8, -8));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @Test
    public void ziyaretEt() throws InterruptedException {
        driver.get("https://facebook.com");
        Thread.sleep(2000);
    }
    @Test
    public void ziyaretEt2() throws InterruptedException {
        driver.get("https://www.google.az");
        Thread.sleep(2000);
    }
    @AfterClass
    public static void testiBagla(){
        driver.quit();
    }
}

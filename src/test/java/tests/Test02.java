package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test02 {
    WebDriver driver;
    @Before // Before metod olaraq istifade edildiyinde her testden once tekraren isleyir
    public void hazirliqEt(){
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
    @After
    public void testBagla(){
        driver.quit();
    }
}

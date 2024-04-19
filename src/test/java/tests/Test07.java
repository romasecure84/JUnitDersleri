package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Test07 {
    static WebDriver driver;

    @BeforeClass // Before metoddan ferqli olaraq butun testlerden once bir defe isleyir
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1382, 744));
        driver.manage().window().setPosition(new Point(-8, -8));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Ignore("ignore funksiyasiyla istediyimiz testi ignore ede bilerik")
    @Test
    public void titleTestGoogle() throws InterruptedException {
        Actions actions = new Actions(driver);
        driver.get("https://google.az");
        Assert.assertTrue(driver.getTitle().contains("Google"));
    }

    @Test
    public void titleTestFacebook() throws InterruptedException {
        Actions actions = new Actions(driver);
        driver.get("https://facebook.com");
        Assert.assertTrue(driver.getTitle().contains("Facebook"));
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}

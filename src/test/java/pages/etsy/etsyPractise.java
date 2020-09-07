package pages.etsy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class etsyPractise {
    WebDriver driver;
    EtsyHomePage etsyHomePage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        etsyHomePage = new EtsyHomePage(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void test1() {
        driver.get("https://www.etsy.com/");
        EtsyHomePage.verifyTitle("Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone");
    }
}

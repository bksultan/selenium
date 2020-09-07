package day9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.herokuapp.HomePage;

import java.util.concurrent.TimeUnit;

public class PageObjectModelIntro {
    WebDriver driver;
    Actions actions;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        actions = new Actions(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
    public void test1(){
        driver.get("https://the-internet.herokuapp.com/");
        HomePage homePage = new HomePage(driver);
        homePage.abTestLink.click();
    }
}

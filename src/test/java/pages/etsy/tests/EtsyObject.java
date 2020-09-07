package pages.etsy.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.etsy.EtsyHomePage;

import java.util.concurrent.TimeUnit;

public class EtsyObject {
    WebDriver driver;
    Actions actions;
    EtsyHomePage HomePage;
    JavascriptExecutor javaScriptExec;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        actions = new Actions(driver);
        HomePage = new EtsyHomePage(driver);
        javaScriptExec = (JavascriptExecutor) driver;

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.etsy.com/");
        EtsyHomePage etsy = new EtsyHomePage(driver);

        etsy.searchBar.sendKeys("antique jewelry" + Keys.ENTER);

        /*Add Filters*/
        etsy.oneBusinessDay.click();
        etsy.priceSearchFrom.sendKeys("100");
        etsy.priceSearchTo.sendKeys("250");
        Thread.sleep(2000);

        etsy.material.click();
        etsy.shopLocation.click();

        Select select = new Select(etsy.dropDown);
        select.selectByVisibleText("Canada");
    }
}

package day17.amazon;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class amazonObject {
    WebDriver driver;
    Actions actions;
    OpenEmrHomePage OpenEmrHomePage;
    JavascriptExecutor javaScriptExec;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        actions = new Actions(driver);
        OpenEmrHomePage = new OpenEmrHomePage(driver);
        javaScriptExec = (JavascriptExecutor) driver;

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        javaScriptExec.executeScript("window.location='https://www.amazon.com/';");
    }

    @Test
    public void test1() throws IOException {
        String currentUrl = driver.getCurrentUrl();
        SoftAssert softAssert = new SoftAssert();
        //softAssert.assertEquals(currentUrl, "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");
        //softAssert.assertAll();

        actions.click(OpenEmrHomePage.searchField).sendKeys("fishing" + Keys.ENTER).perform();

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < OpenEmrHomePage.productNames.size(); i++) {
            map.put(OpenEmrHomePage.productNames.get(i).getText(), OpenEmrHomePage.productPrices.get(i).getText());
        }
        System.out.println(map);

    }
}

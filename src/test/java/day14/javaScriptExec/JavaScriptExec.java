package day14.javaScriptExec;

import day14.screenshotAmazon.homePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaScriptExec {
    WebDriver driver;
    day14.screenshotAmazon.homePage homePage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        homePage = new homePage(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://amazon.com");
    }

    @Test
    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 600)");
    }

    @Test
    public void pageTitle() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String pageTitle = js.executeScript("return document.title").toString();
        System.out.println(pageTitle);
    }

    @Test
    public void pageURL() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String pageTitle = js.executeScript("return document.URL").toString();
        System.out.println(pageTitle);
    }
}

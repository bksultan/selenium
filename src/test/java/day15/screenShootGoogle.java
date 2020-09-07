package day15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.commonUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class screenShootGoogle {
    WebDriver driver;
    JavascriptExecutor js;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void test1() throws IOException {
        driver.get("https://google.com");

        commonUtils.takeScreenshot(driver, "screenShootGoogle");

        String pageTitle = js.executeScript("return document.title").toString();
        String pageURL = js.executeScript("return document.URL").toString();
        Assert.assertEquals("Google", pageTitle);
        Assert.assertEquals("https://www.google.com/", pageURL);

        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("10x rule" + Keys.ENTER);

        String pageTitle1 = js.executeScript("return document.title").toString();
        Assert.assertEquals("10x rule - Google Search", pageTitle1);

        js.executeScript("window.scrollBy(0, 3500)");

        commonUtils.takeScreenshot(driver, "screenShootGoogle");
    }
}

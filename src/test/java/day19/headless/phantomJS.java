package day19.headless;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.commonUtils;

import java.io.IOException;

public class phantomJS {
    WebDriver phantomDriver;
    WebDriver chromeDriver;

    @Test
    public void phantomJSHeadlessTest() throws IOException {
        WebDriverManager.phantomjs().setup();
        phantomDriver = new PhantomJSDriver();
        phantomDriver.get("https://amazon.com");
        WebElement searchField = phantomDriver.findElement(By.id("twotabsearchtextbox"));
        searchField.sendKeys("selenium cookbook" + Keys.ENTER);
        Assert.assertTrue(phantomDriver.getCurrentUrl().contains("selenium"));
        commonUtils.takeScreenshot(phantomDriver, "phantomJSScreenshot");
    }
    @Test
    public void chromeJSHeadlessTest() throws IOException {
        WebDriverManager.chromedriver().setup();
        //DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        chromeDriver = new ChromeDriver(options);

        chromeDriver.get("https://amazon.com");
        WebElement searchField = chromeDriver.findElement(By.id("twotabsearchtextbox"));
        searchField.sendKeys("selenium cookbook" + Keys.ENTER);
        Assert.assertTrue(chromeDriver.getCurrentUrl().contains("selenium"));
        commonUtils.takeScreenshot(chromeDriver, "chromeJSScreenshot");
    }

    @Test
    public void test(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        chromeDriver = new ChromeDriver(options);

        chromeDriver.get("https://amazon.com");
    }

//    @AfterMethod
//    public void teardown(ITestResult testResult) throws IOException {
//        if (testResult.isSuccess()) {
//            commonUtils.takeScreenshot(phantomDriver, "phantomJSScreenshot");
//        }
//    }
}

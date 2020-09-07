package day14.screenshotAmazon;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class screenshotIntro {
    WebDriver driver;
    homePage homePage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        homePage = new homePage(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://amazon.com");
    }

    @AfterMethod
    public void teardown(ITestResult testResult) throws IOException {
        if (!testResult.isSuccess()) {
            System.out.println("Test " + testResult.getName() + " has failed, taking screenshot");

            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String destination = "src/test/java/day14/screenshotFile/" + testResult.getName() + System.currentTimeMillis() + ".png";
            /*•*/
            String destination2 = String.format("src/test/java/day14/screenshotFile/%s%d.%s", testResult.getName(), System.currentTimeMillis(), "png");
            System.out.println(destination2);

            File destScreenshot = new File(destination);
            FileUtils.copyFile(screenshot, destScreenshot);
        }
    }

    @Test
    public void test1() {
        homePage homePage = new homePage(driver);
        SoftAssert softAssert = new SoftAssert();

        homePage.searchField.sendKeys("Selenium Cookbook");
        homePage.searchButton.click();

        softAssert.assertEquals(driver.getTitle(), "Amazon.co : Selenium cookbook", "Failed to verify page title");
        softAssert.assertAll();
    }
}

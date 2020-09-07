package day19.amazonSearchInTwoBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.IOException;

public class amazonHomePage extends TestBase {
    amazonLocators amazonLocators;

    @Test
    public void LoginTestObjectTest() throws IOException {
        //amazonLocators = new amazonLocators(driver);
        amazonLocators = amazonLocators.getAmazonResultPage(driver);
        driver.get("https://www.amazon.com/");
        amazonLocators.searchField.sendKeys("selenium cookbook");
        amazonLocators.submit.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleIs("Amazon.com : selenium cookbook"));
    }
}

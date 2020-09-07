package day16.alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class alertIntroObject {
    WebDriver driver;
    Actions actions;
    alertHomePage AlertHomePage;
    JavascriptExecutor javaScriptExec;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        actions = new Actions(driver);
        AlertHomePage = new alertHomePage(driver);
        javaScriptExec = (JavascriptExecutor) driver;

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        javaScriptExec.executeScript("window.location='https://the-internet.herokuapp.com/javascript_alerts';");
    }

    @Test(priority = 0)
    public void test1() {
        actions.click(AlertHomePage.jsAlert).perform();
        utilities.commonUtils.waitFor(1);
        driver.switchTo().alert().accept();
    }

    @Test(priority = 1)
    public void test2() {
        actions.click(AlertHomePage.jsAlert1).perform();
        utilities.commonUtils.waitFor(1);
        driver.switchTo().alert().accept();
        Assert.assertEquals(AlertHomePage.jsConfirmResult.getText(), "You clicked: Ok");
    }

    @Test(priority = 2)
    public void test3() {
        actions.click(AlertHomePage.jsAlert2).perform();
        String textResult = "Hello World";

        driver.switchTo().alert().sendKeys(textResult);
        driver.switchTo().alert().accept();

        Assert.assertTrue(AlertHomePage.jsConfirmResult.getText().contains(textResult));
    }
}

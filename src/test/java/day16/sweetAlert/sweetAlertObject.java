package day16.sweetAlert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class sweetAlertObject {
    WebDriver driver;
    Actions actions;
    sweetAlertHomePage sweetAlertHomePage;
    JavascriptExecutor javaScriptExec;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        actions = new Actions(driver);
        sweetAlertHomePage = new sweetAlertHomePage(driver);
        javaScriptExec = (JavascriptExecutor) driver;

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        javaScriptExec.executeScript("window.location='https://sweetalert.js.org/';");
    }

    @Test
    public void leftPreview(){
        String currentURL = driver.getCurrentUrl();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(currentURL, "https://sweetalert.js.org/");

        actions.click(sweetAlertHomePage.leftPreviewBtn).perform();
    }

    @Test
    public void rightPreview(){
        actions.click(sweetAlertHomePage.rightPreviewBtn).perform();
    }
}

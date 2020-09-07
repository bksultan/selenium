package day15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.commonUtils;

import java.util.concurrent.TimeUnit;

public class advJavaScriptExec {
    WebDriver driver;
    JavascriptExecutor javaScriptExec;
    Actions actions;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        actions = new Actions(driver);
        javaScriptExec = (JavascriptExecutor) driver;

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void navigateToPageTest() {
        javaScriptExec.executeScript("window.location='https://amazon.com';");
    }

    @Test
    public void refreshPageTest() {
        javaScriptExec.executeScript("window.location='https://amazon.com';");
        commonUtils.waitFor(2);
        javaScriptExec.executeScript("history.go(0);");
    }

    @Test
    public void checkboxTest() {
        javaScriptExec.executeScript("window.location='https://letskodeit.teachable.com/p/practice';");
        javaScriptExec.executeScript("document.getElementById('bmwcheck').checked=true");
        commonUtils.waitFor(1);
        javaScriptExec.executeScript("document.getElementById('bmwcheck').checked=false");
    }

    @Test
    public void checkIfPageFullyLoadedTest(){
        javaScriptExec.executeScript("window.location='https://amazon.com';");
        String readyState = javaScriptExec.executeScript("return document.readyState").toString();
        System.out.println(readyState);
    }
}

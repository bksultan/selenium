package day15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class fileUpload {
    WebDriver driver;
    Actions actions;
    JavascriptExecutor javaScriptExec;

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
    public void fileUploadTest(){
        driver.navigate().to("https://the-internet.herokuapp.com/upload");

        WebElement chooseFileButton = driver.findElement(By.cssSelector("#file-upload"));
        WebElement fileSubmitButton = driver.findElement(By.cssSelector("#file-submit"));

        chooseFileButton.sendKeys("C:\\Users\\User\\Downloads\\techtorial.txt");

        fileSubmitButton.click();
    }
}

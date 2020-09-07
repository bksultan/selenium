package day18.synchronization;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWait {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void test1() {
        driver.get("https://amazon.com");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
        searchBar = wait.until(ExpectedConditions.elementToBeClickable(searchBar));
        searchBar.click();
    }

    @Test
    public void test2() {
        driver.get("https://amazon.com");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.titleIs("Techtorial"));
    }
    @Test
    public void test3() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.urlToBe("https://the-internet.herokuapp.com/nested_frames"));

        WebElement topFrame = driver.findElement(By.name("frame-top"));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(topFrame));

        WebElement middleFrame = driver.findElement(By.name("frame-middle"));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(middleFrame));

        WebElement text = driver.findElement(By.id("content"));
        System.out.println(text.getText());
    }
}

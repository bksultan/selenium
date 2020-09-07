package day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class KeyboardActions {
    WebDriver driver;
    Actions actions;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        actions = new Actions(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void navigateToPage() {

    }

    @AfterMethod
    public void teardown() {
        //driver.quit();
    }

    @Test
    public void intro() {
        driver.get("https://www.google.com/");
        WebElement searchInput = driver.findElement(By.xpath("//input[@name='q']"));
        actions.sendKeys(searchInput, Keys.SHIFT + "Selenium Cookbook" + Keys.ENTER);
        WebElement link = driver.findElement(By.xpath("//a[@href='https://www.amazon.com/Selenium-Testing-Cookbook-Gundecha-Unmesh/dp/1849515743']"));
        actions.keyDown(Keys.CONTROL).click(link).perform();
    }

    @Test
    public void intro1() {
        driver.get("https://www.google.com/");
        WebElement searchInput = driver.findElement(By.xpath("//input[@name='q']"));
        actions.keyDown(Keys.SHIFT).sendKeys(searchInput, "Selenium Cookbook" + Keys.ENTER).keyUp(Keys.SHIFT).perform();
        WebElement link = driver.findElement(By.xpath("//a[@href='https://www.amazon.com/Selenium-Testing-Cookbook-Gundecha-Unmesh/dp/1849515743']"));
        actions.keyDown(Keys.CONTROL).click(link).keyUp(Keys.CONTROL).perform();
    }
}

package day9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropdownRecap {
    WebDriver driver;
    WebElement dropDown;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/dropdown");
        dropDown = driver.findElement(By.id("dropdown"));
    }

    @Test
    public void test() {
        Select dropDownHandler = new Select(dropDown);
        dropDownHandler.selectByVisibleText("Option 2");
    }

    @Test
    public void test1() {
        Select dropDownHandler = new Select(dropDown);
        dropDownHandler.selectByIndex(2);
        List<WebElement> dropDownOptions = dropDownHandler.getOptions();
        Assert.assertEquals(dropDownOptions.size(), 3, "Dropdown size verification error");
    }

    @Test
    public void test2() {
        Select dropDownHandler = new Select(dropDown);
        dropDownHandler.selectByIndex(2);
        List<WebElement> options = dropDownHandler.getOptions();
        WebElement option2 = options.get(2);
        System.out.println(options.get(2).getText());
        Assert.assertTrue(option2.isSelected());
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
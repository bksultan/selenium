package day9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonSearchDropdown {
    WebDriver driver;

//    @BeforeMethod
//    public void setup() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.get("https://amazon.com");
//    }

    @Test
    public void test1() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://amazon.com");

        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
        Select dropDownHandler = new Select(dropDown);

        String expectedOption = "Prime Video";
        //define empty list of string for options name
        List<String> dropdownText = new ArrayList<>();
        //get all options from dropdown
        List<WebElement> dropdownOptions = dropDownHandler.getOptions();
        //iterate over the list of dropdown options and get text from options
        //and store the text in list of String
        for (WebElement element : dropdownOptions) {
            String name = element.getText();
            dropdownText.add(name);
        }
        Assert.assertTrue(dropdownText.contains(expectedOption));
    }

    @Test
    public void test2() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://amazon.com");

        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
        Select dropDownHandler = new Select(dropDown);

        String expectedOption = "Prime Video";
        List<WebElement> dropdownOptions = dropDownHandler.getOptions();
        boolean isPresent = false;

        for (WebElement element : dropdownOptions) {
            String name = element.getText();
            if (name.equalsIgnoreCase(expectedOption)) {
                isPresent = true;
                break;
            }
        }
        Assert.assertTrue(isPresent);
    }

    @Test
    public void test3() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://amazon.com");

        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
        Select dropDownHandler = new Select(dropDown);

        String expectedOption = "Prime Video";
        dropDownHandler.selectByVisibleText(expectedOption);
        WebElement selectedOption = dropDownHandler.getFirstSelectedOption();
        String selectedText = selectedOption.getText();
        Assert.assertEquals(selectedText, expectedOption, "Fail to verify option");
    }
}

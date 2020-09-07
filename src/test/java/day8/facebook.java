package day8;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class facebook {
    @Test
    public void test1() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.facebook.com/");

        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='radio']"));
        checkboxes.get(0).click();

        Assert.assertFalse(checkboxes.get(1).isSelected());
        Assert.assertFalse(checkboxes.get(2).isSelected());
    }
    @Test
    public void test2() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.facebook.com/");

        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='radio']"));
        checkboxes.get(1).click();

        Assert.assertFalse(checkboxes.get(0).isSelected());
        Assert.assertFalse(checkboxes.get(2).isSelected());
    }
    @Test
    public void test3() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.facebook.com/");

        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='radio']"));
        checkboxes.get(2).click();

        Assert.assertFalse(checkboxes.get(1).isSelected());
        Assert.assertFalse(checkboxes.get(0).isSelected());
    }
}

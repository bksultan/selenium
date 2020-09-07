package day7;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Checkbox {
    @Test
    public void test1() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  // connect to chromedriver
        WebDriver driver = new ChromeDriver();                              // open the browser
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/");

        WebElement checkboxLink = driver.findElement(By.xpath("//a[@href='/checkboxes']"));
        checkboxLink.click();

        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        checkboxes.get(0).click();
        Assert.assertTrue(checkboxes.get(0).isSelected());
        checkboxes.get(1).click();
        Assert.assertFalse(checkboxes.get(1).isSelected());
    }
    @Test
    public void test2() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  // connect to chromedriver
        WebDriver driver = new ChromeDriver();                              // open the browser
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/");

        WebElement checkboxLink = driver.findElement(By.xpath("//a[@href='/checkboxes']"));
        checkboxLink.click();

        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement checkbox: checkboxes){
            if (checkbox.isSelected()){
                System.out.println("checkbox is checked");
                checkbox.click();
            }else {
                System.out.println("checkbox is not checked");
                checkbox.click();
            }
        }
    }
}

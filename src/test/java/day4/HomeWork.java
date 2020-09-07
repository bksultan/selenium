package day4;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork {
    @Test
    public void test2(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  // connect to chromedriver
        WebDriver driver = new ChromeDriver();                              // open the browser
        driver.manage().window().maximize();
        driver.navigate().to("https://www.ebay.com/");

        driver.findElement(By.id("gh-ac")).sendKeys("Selenium cookbook" + Keys.ENTER);
        driver.findElement(By.xpath("//li[@data-view='mi:1686|iid:1']//div[@class='s-item__info clearfix']/a")).click();
        WebElement countInput = driver.findElement(By.id("qtyTextBox"));
        countInput.clear();
        countInput.sendKeys("5");
        WebElement chkFreeShipping = driver.findElement(By.xpath("//span[@id='fshippingCost']/span"));
        Assert.assertEquals("free", chkFreeShipping.getText().toLowerCase());
    }
}

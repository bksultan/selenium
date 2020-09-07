package day6;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Kayak {
    @Test
    public void test1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  // connect to chromedriver
        WebDriver driver = new ChromeDriver();                              // open the browser
        driver.manage().window().maximize();
        driver.navigate().to("https://www.kayak.com/");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Search Flights, Hotels & Rental Cars | KAYAK";
        Assert.assertEquals("Title is correct", actualTitle, expectedTitle);

        Thread.sleep(2000);
        WebElement searchField = driver.findElement(By.xpath("//div[@aria-label='Pick-up location']"));
        searchField.click();
        Thread.sleep(2000);
        WebElement textBoxCar = driver.findElement(By.xpath("//input[@aria-label='Pick-up location']"));
        textBoxCar.sendKeys("LAX" + Keys.ENTER);
        WebElement pickupDate = driver.findElement(By.xpath("//div[starts-with(@class,'Common-Widgets-Datepicker-DateModal')]/div[@aria-label='Pick-up date']"));
        pickupDate.click();
        Thread.sleep(2000);
        WebElement aug29 = driver.findElement(By.xpath("//div[@aria-label='August 29']"));
        aug29.click();
        aug29.click();
        Thread.sleep(1000);
        WebElement pickupTime = driver.findElement(By.xpath("//ul[contains(@id,'RangeInput-start-time')]//li[@aria-label='Noon']"));
        pickupTime.click();
        WebElement dropOffDate = driver.findElement(By.xpath("//div[starts-with(@class,'Common-Widgets-Datepicker-DateModal')]/div[@aria-label='Drop-off date']"));
        dropOffDate.click();
        Thread.sleep(1000);
        WebElement sep4 = driver.findElement(By.xpath("//div[@aria-label='September 4']"));
        sep4.click();
        Thread.sleep(1000);
        WebElement searchButton = driver.findElement(By.xpath("//button[@aria-label='Search cars']"));
        searchButton.click();
    }
}

package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HerokuAppOne {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  // connect to chromedriver
        WebDriver driver = new ChromeDriver();                              // open the browser
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/");

        WebElement abTestlinkOne = driver.findElement(By.xpath("//a[@href='/context_menu']"));
        Thread.sleep(500);
        abTestlinkOne.click();
        Thread.sleep(500);
        driver.navigate().back();

        WebElement abTestlinkTwo = driver.findElement(By.xpath("//a[@href='/add_remove_elements/']"));
        Thread.sleep(500);
        abTestlinkTwo.click();
        Thread.sleep(500);
        driver.navigate().back();

        WebElement abTestlinkThree = driver.findElement(By.xpath("//a[@href='/broken_images']"));
        Thread.sleep(500);
        abTestlinkThree.click();
        Thread.sleep(500);
        driver.navigate().back();

        WebElement abTestlinkFour = driver.findElement(By.xpath("//a[@href='/checkboxes']"));
        Thread.sleep(500);
        abTestlinkFour.click();
        Thread.sleep(500);
        driver.navigate().back();

        WebElement abTestlinkFive = driver.findElement(By.xpath("//a[@href='/dynamic_content']"));
        Thread.sleep(500);
        abTestlinkFive.click();
        Thread.sleep(500);
        driver.navigate().back();

        WebElement abTestlinkSix = driver.findElement(By.xpath("//a[@href='/dropdown']"));
        Thread.sleep(500);
        abTestlinkSix.click();
        Thread.sleep(500);
        driver.navigate().back();

        WebElement abTestlinkSeven = driver.findElement(By.xpath("//a[@href='/broken_images']"));
        Thread.sleep(500);
        abTestlinkSeven.click();
        Thread.sleep(500);
        driver.navigate().back();
    }
}

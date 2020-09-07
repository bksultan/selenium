package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HerokuAppHome {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  // connect to chromedriver
        WebDriver driver = new ChromeDriver();                              // open the browser
        driver.manage().window().maximize();

        driver.navigate().to("https://the-internet.herokuapp.com/");

        WebElement abTestlinkOne = driver.findElement(By.xpath("//a[@href='/add_remove_elements/']"));
        Thread.sleep(500);
        abTestlinkOne.click();

        WebElement buttonClick = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        buttonClick.click();
        Thread.sleep(500);
        buttonClick.click();
        Thread.sleep(500);
        buttonClick.click();
        Thread.sleep(500);

        driver.navigate().to("https://the-internet.herokuapp.com/key_presses");
        driver.findElement(By.xpath("//input[@type='text']"))
                .sendKeys("Hello Techtorial");

    }
}

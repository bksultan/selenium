package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Herokuapp {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  // connect to chromedriver
        WebDriver driver = new ChromeDriver();                              // open the browser
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/");

        WebElement abTestlink = driver.findElement(By.xpath("//a[@href='//download_secure']"));
        Thread.sleep(3000);
        abTestlink.click();

    }
}

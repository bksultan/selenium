package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dropdown {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  // connect to chromedriver
        WebDriver driver = new ChromeDriver();                              // open the browser
        driver.manage().window().maximize();

        driver.navigate().to("https://the-internet.herokuapp.com/");

        WebElement Testlink = driver.findElement(By.xpath("//a[@href='/dropdown']"));
        Thread.sleep(500);
        Testlink.click();

        driver.findElement(By.id("dropdown")).click();
    }
}

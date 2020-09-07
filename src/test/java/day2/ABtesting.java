package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ABtesting {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  // connect to chromedriver
        WebDriver driver = new ChromeDriver();                              // open the browser
        driver.manage().window().maximize();

        driver.navigate().to("https://the-internet.herokuapp.com/");

        WebElement abTestlinkOne = driver.findElement(By.xpath("//a[@href='/abtest']"));
        Thread.sleep(500);
        abTestlinkOne.click();

        WebElement textElement = driver.findElement(By.id("content"));
        String text = textElement.getText();
        System.out.println(text);
    }
}

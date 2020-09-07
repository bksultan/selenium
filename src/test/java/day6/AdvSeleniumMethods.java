package day6;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdvSeleniumMethods {
    @Test
    public void adv1(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  // connect to chromedriver
        WebDriver driver = new ChromeDriver();                              // open the browser
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/");



        WebElement testLink = driver.findElement(By.xpath("//a[text()='A/B Testing']"));
        String hrefValue = testLink.getAttribute("href");
        System.out.println(hrefValue);

        WebElement header = driver.findElement(By.tagName("h1"));
        String testTag = header.getAttribute("class");
        System.out.println(testTag);

        WebElement innerTxt = driver.findElement(By.xpath("//a[@href='/drag_and_drop']"));
        String testInnerTxt = innerTxt.getAttribute("innerText");
        System.out.println(testInnerTxt);

        WebElement body = driver.findElement(By.tagName("body"));
        String testBody = body.getAttribute("innerHTML");
        System.out.println(testBody);
    }
}

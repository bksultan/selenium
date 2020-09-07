package day6;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class MultipleElements {
    @Test
    public void test1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  // connect to chromedriver
        WebDriver driver = new ChromeDriver();                              // open the browser
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/");
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals("Title is correct", actualTitle, expectedTitle);

        List<WebElement> links = driver.findElements(By.xpath("//li/a"));

        for(int i=0; i<links.size(); i++){
            //String linkText = links.get(i).getText();
            //System.out.println(linkText);
            Thread.sleep(500);
            links = driver.findElements(By.xpath("//li/a"));
            links.get(i).click();
            driver.navigate().back();
        }
    }
}

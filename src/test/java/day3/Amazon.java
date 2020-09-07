package day3;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {
    @Test
    public void test1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  // connect to chromedriver
        WebDriver driver = new ChromeDriver();                              // open the browser
        driver.manage().window().maximize();
        driver.navigate().to("https://www.amazon.com/");

        driver.findElement(By.id("twotabsearchtextbox"))
                .sendKeys("Java for dummies" + Keys.ENTER);
        Thread.sleep(2000);
        WebElement testLink = driver.findElement(By.xpath("//*[@id=\"p_lbr_books_series_browse-bin/For Dummies\"]/span/a"));
        testLink.click();
        Assert.fail();
    }
    @Test
    public void test2(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  // connect to chromedriver
        WebDriver driver = new ChromeDriver();                              // open the browser
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        String url = driver.getCurrentUrl();
        System.out.println("current URL" + url);

        String title = driver.getTitle();
        System.out.println("Title: " + title);
    }
}

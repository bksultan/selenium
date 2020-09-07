package day4;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork1 {
    @Test
    public void test1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  // connect to chromedriver
        WebDriver driver = new ChromeDriver();                              // open the browser
        driver.manage().window().maximize();
        driver.navigate().to("https://www.etsy.com/");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//ul[@role='menubar']//a[@href='/c/toys-and-entertainment?ref=catnav-11049']")).click();
        driver.findElement(By.xpath("//a[@href='https://www.etsy.com/c/toys_and_entertainment?explicit=1&max_processing_days=1&instant_download=false&locationQuery=6252001']/span")).click();
        driver.findElement(By.id("search-filter-min-price-input")).sendKeys("1");
        driver.findElement(By.id("search-filter-max-price-input")).sendKeys("1000" + Keys.ENTER);
    }
    @Test
    public void test2(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  // connect to chromedriver
        WebDriver driver = new ChromeDriver();                              // open the browser
        driver.manage().window().maximize();

        driver.navigate().to("https://www.etsy.com/");
        driver.findElement(By.xpath("/html/body/div[5]/div/div/ul/li[6]/a")).click();

        driver.navigate().to("https://amazon.com");
        driver.findElement(By.xpath("//a[contains(@href, 'foods_in')]"));

        driver.navigate().to("https://amazon.com");
        driver.findElement(By.xpath("//span[contains(text(),'Nonfiction')]"));
    }
}

package day2;

import day6.amazonsearch;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Etsy {
    @Test
    public void test1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  // connect to chromedriver
        WebDriver driver = new ChromeDriver();                              // open the browser
        driver.manage().window().maximize();
        driver.navigate().to("https://www.etsy.com/");

        driver.findElement(By.id("global-enhancements-search-query"))
                .sendKeys("samsung" + Keys.ENTER);
        WebElement resultCount = driver.findElement(By.className("wt-display-inline-flex-lg"));

        String resultStr = resultCount.getText();
        String[] splittedResult = resultStr.split(" ");
        int count = Integer.parseInt(splittedResult[0].substring(1).replace(",", "").trim());

        Assert.assertTrue(count > 0);
    }

    @Test
    public void test2() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  // connect to chromedriver
        WebDriver driver = new ChromeDriver();                              // open the browser
        driver.manage().window().maximize();
        driver.navigate().to("https://www.etsy.com/");

        driver.findElement(By.id("global-enhancements-search-query"))
                .sendKeys("samsung" + Keys.ENTER);
        Thread.sleep(2000);
        WebElement price = driver.findElement(By.xpath("//a[@data-path='Under $25']/span"));
        price.click();
        Thread.sleep(2000);

        WebElement priceElement = driver.findElement(By.xpath("//span[@class='currency-value']"));
        String priceStr = priceElement.getText();
        double priceDouble = Double.parseDouble(priceStr);

        Assert.assertTrue(priceDouble < 25);
    }

    @Test
    public void test3() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  // connect to chromedriver
        WebDriver driver = new ChromeDriver();                              // open the browser
        driver.manage().window().maximize();
        driver.navigate().to("https://www.etsy.com/listing/634844888/jardin-bouquet-tote-denim?ref=hp_rv-1");
        WebElement submit = driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--filled wt-width-full']"));
        submit.click();

        WebElement currencyValue = driver.findElement(By.xpath("//li[@data-listing-id='634844888']/div/div[2]/div/div[2]/div/div[2]//span[@class='currency-value']"));
        String priceStr = currencyValue.getText();
        double price = Double.parseDouble(priceStr);
        System.out.println(price);
        Thread.sleep(2000);

        WebElement value = driver.findElement(By.xpath("//li[@data-listing-id='634844888']/div/div[2]/div/div[2]/div/div//option[2]"));
        value.click();
        Thread.sleep(2000);

        WebElement currencyValue2 = driver.findElement(By.xpath("//li[@data-listing-id='634844888']/div/div[2]/div/div[2]/div/div[2]//span[@class='currency-value']"));
        String priceStr2 = currencyValue2.getText();
        double multiplePrice = Double.parseDouble(priceStr2);
        Assert.assertTrue(multiplePrice==price*2);
        System.out.println(""+multiplePrice+" "+price+" "+price*2);
    }
}

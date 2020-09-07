package day5;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class google {
    @Test
    public void test1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  // connect to chromedriver
        WebDriver driver = new ChromeDriver();                              // open the browser
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com/");

        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("selenium cookbook");
        WebElement search = driver.findElement(By.xpath("//div[@class='UUbT9']//input[@name='btnK']"));
        search.click();
        WebElement result = driver.findElement(By.id("result-stats"));
        String count = result.getText();


        String[] splittedResult = count.split(" ");
        System.out.println(splittedResult[1]);
        int countInt = Integer.parseInt(splittedResult[1].replace(",", ""));
        System.out.println(countInt);
        Assert.assertTrue(countInt>0);
        //System.out.println(countInt);
    }
}

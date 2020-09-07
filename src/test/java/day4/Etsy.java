package day4;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Etsy {
    @Test
    public void test1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.etsy.com/");

        driver.findElement(By.xpath("//a[@href='https://www.etsy.com/help?ref=ftr']/span")).click();
        Thread.sleep(2000);

        String url = driver.getCurrentUrl();
        System.out.println("current URL: " + url);

        String title = driver.getTitle();
        System.out.println("Title: " + title);

        WebElement header = driver.findElement(By.linkText("Help Center"));
        System.out.println(header.getText());
    }
}

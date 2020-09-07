package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class YouTube {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
        driver.findElement(By.xpath("//input[@type='email']"))
                .sendKeys("beksultanggd@gmail.com" +Keys.ENTER);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@type='password']"))
                .sendKeys("1234567" +Keys.ENTER);

    }
}

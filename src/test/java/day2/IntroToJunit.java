package day2;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IntroToJunit {
    @Test
    public void test1(){
        System.out.println("Hello world");
    }
    @Test
    public void test2() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  // connect to chromedriver
        WebDriver driver = new ChromeDriver();                              // open the browser
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/");

        WebElement Testlink = driver.findElement(By.xpath("//a[@href='/checkboxes']"));
        Thread.sleep(500);
        Testlink.click();
        WebElement header = driver.findElement(By.tagName("h3"));

        String headerText = header.getText();
        Assert.assertEquals("checkboxes", headerText.toLowerCase());
    }
}

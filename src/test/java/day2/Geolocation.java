package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Geolocation {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  // connect to chromedriver
        WebDriver driver = new ChromeDriver();                              // open the browser
        driver.manage().window().maximize();

        driver.navigate().to("https://the-internet.herokuapp.com/");

        WebElement Testlink = driver.findElement(By.xpath("//a[@href='/geolocation']"));
        Thread.sleep(500);
        Testlink.click();

        WebElement textElement = driver.findElement(By.id("demo"));
        String text = textElement.getText();
        System.out.println(text);

        WebElement actual = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3"));
        String actualResult = actual.getText();
        String result = "Geolocation";
        if(actualResult.equalsIgnoreCase(result)){
            System.out.println("Test passed");
        }else System.out.println("Test not passed");
    }
}

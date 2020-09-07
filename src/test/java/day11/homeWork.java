package day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class homeWork {
    WebDriver driver;
    Actions actions;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        actions = new Actions(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void sendMsg() throws InterruptedException {
        driver.get("https://www.gmail.com/");
        WebElement login = driver.findElement(By.xpath("//input[@type='email']"));
        WebElement nextBtn = driver.findElement(By.xpath("//div[@id='identifierNext']//button"));
        actions.sendKeys(login, "beksultanggd@gmail.com").perform();
        actions.click(nextBtn).perform();

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement nextBtn1 = driver.findElement(By.xpath("//div[@id='passwordNext']//button"));

        Thread.sleep(2000);
        actions.sendKeys(password, "#Widescreen5277").perform();
        actions.click(nextBtn1).perform();

        WebElement newMail = driver.findElement(By.xpath("//div[@class='T-I T-I-KE L3']"));
        actions.click(newMail).perform();

        WebElement formTo = driver.findElement(By.xpath("//textarea[@id=':rf']"));
        actions.sendKeys(formTo, "info@techtorialacademy.com").perform();
        Thread.sleep(2000);

        WebElement formSubject = driver.findElement(By.xpath("//input[@id=':qx']"));
        actions.click(formSubject);
        actions.sendKeys(formSubject, "Message using Selenium").perform();

        WebElement formSend = driver.findElement(By.id(":qn"));
        actions.click(formSend).perform();
    }
}

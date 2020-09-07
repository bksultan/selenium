package projectDay;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Project3 {
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
    public void test() throws InterruptedException {

        driver.get("https://calculator.s3.amazonaws.com/index.html");
        Thread.sleep(2000);
        WebElement clickOldCalc = driver.findElement(By.xpath("//button[@class='gwt-Button PRCPopupOldcalculatorLink']"));
        actions.click(clickOldCalc).perform();


        WebElement instancePlus = driver.findElement(By.xpath("//div[@class='cell Instances rowsSection']//img[@src='//d2zogmwzrm9slh.cloudfront.net/ver20200806gR/common/icons/small/add.png']"));
        actions.click(instancePlus).perform();
        WebElement typeOfInstanceLast = driver.findElement(By.xpath("(//div[@class='gwt-HTML field SF_EC2_INSTANCE_FIELD_TYPE instanceTypeField rowDialogSelectorFieldView'])[position()=last()]"));
        actions.click(typeOfInstanceLast).perform();
        Thread.sleep(2000);
        WebElement t1micro = driver.findElement(By.xpath("//label[@for='gwt-uid-673']/preceding-sibling::input"));
        actions.click(t1micro).perform();
        WebElement closeAndSave = driver.findElement(By.xpath("(//button[@class='gwt-Button'])[position()=last()]"));
        actions.click(closeAndSave).perform();
        WebElement instanceLabel = driver.findElement(By.xpath("(//table[@class='SF_EC2_INSTANCE_FIELD_DESCRIPTION field textField']//input[@class='gwt-TextBox input'])[position()=last()]"));
        actions.sendKeys(instanceLabel, "T1 Linux Micro (Free)").perform();

        actions.click(instancePlus).perform();
        actions.click(typeOfInstanceLast).perform();
        Thread.sleep(2000);
        WebElement t2micro = driver.findElement(By.xpath("//input[@id='gwt-uid-1276']"));
        actions.click(t2micro).perform();
        WebElement closeAndSave1 = driver.findElement(By.xpath("(//button[@class='gwt-Button'])[position()=last()]"));
        actions.click(closeAndSave1).perform();
        WebElement instanceLabel1 = driver.findElement(By.xpath("(//table[@class='SF_EC2_INSTANCE_FIELD_DESCRIPTION field textField']//input[@class='gwt-TextBox input'])[position()=last()]"));
        actions.sendKeys(instanceLabel1, "T1 Linux Micro 2").perform();

        actions.click(instancePlus).perform();
        actions.click(typeOfInstanceLast).perform();
        Thread.sleep(2000);
        WebElement t2medium = driver.findElement(By.xpath("//input[@id='gwt-uid-943']"));
        actions.click(t2medium).perform();
        WebElement closeAndSave2 = driver.findElement(By.xpath("(//button[@class='gwt-Button'])[position()=last()]"));
        actions.click(closeAndSave2).perform();
    }
}

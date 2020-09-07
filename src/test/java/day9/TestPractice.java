package day9;

import day6.amazonsearch;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestPractice {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://letskodeit.teachable.com/p/practice");
    }
    @Test
    public void test1(){
        List<WebElement> radioBtn = driver.findElements(By.xpath("//input[@type='radio']"));
        boolean btnIsSelected = false;
        for (int i=0; i<radioBtn.size(); i++){
            if (radioBtn.get(i).isSelected()){
                btnIsSelected = true;
                break;
            }
        }
        Assert.assertFalse(btnIsSelected);
    }

    @Test
    public void test22(){
        List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@checked and @type='radio']"));
        Assert.assertTrue(radioButtons.size() == 0);
    }

    @Test
    public void test2(){
        List<WebElement> radioBtn = driver.findElements(By.xpath("//input[@type='radio']"));
        radioBtn.get(1).click();

        org.junit.Assert.assertTrue(radioBtn.get(1).isSelected());
        org.junit.Assert.assertFalse(radioBtn.get(2).isSelected());
        org.junit.Assert.assertFalse(radioBtn.get(0).isSelected());
    }
    @Test
    public void test3(){
        List<WebElement> radioBtn = driver.findElements(By.xpath("//input[@type='radio']"));
        radioBtn.get(1).click();
        Assert.assertTrue(radioBtn.get(1).isSelected());
        Assert.assertFalse(radioBtn.get(2).isSelected());
        Assert.assertFalse(radioBtn.get(0).isSelected());

        radioBtn.get(2).click();
        Assert.assertTrue(radioBtn.get(2).isSelected());
        Assert.assertFalse(radioBtn.get(1).isSelected());
    }
    @Test
    public void test4(){
        WebElement multiSelect = driver.findElement(By.id("multiple-select-example"));
        Select select = new Select(multiSelect);
        if (select.isMultiple()){
            select.selectByVisibleText("Apple");
            select.selectByVisibleText("Peach");
        }else{
            select.selectByVisibleText("Orange");
        }
        amazonsearch.waitFor(2);
        select.deselectByVisibleText("Apple");
        amazonsearch.waitFor(2);
        select.deselectAll();
    }
}

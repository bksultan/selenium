package day8;

import day6.amazonsearch;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {
    @Test
    public void test1() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/dropdown");

        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        select.selectByIndex(2);
    }

    @Test
    public void test2() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://amazon.com");

        WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Books");

        amazonsearch.waitFor(2);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Harry Potter" + Keys.ENTER);

        WebElement searchResult = driver.findElement(By.xpath("//span[@class='a-icon-alt']/../../../../../../preceding-sibling::div[@class='a-section a-spacing-none']/h2/a"));
        String finalResult = searchResult.getText();

        Assert.assertTrue(finalResult.toLowerCase().contains("harry"));
        Assert.assertTrue(finalResult.toLowerCase().contains("potter"));
        Assert.assertTrue(finalResult.toLowerCase().contains("harry potter"));
    }
}

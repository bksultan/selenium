package day7;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Recap {
    @Test
    public void test1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://ebay.com/");

        WebElement searchInput = driver.findElement(By.id("gh-ac"));
        searchInput.sendKeys("Java for dummies" + Keys.ENTER);

        WebElement pageBtn = driver.findElement(By.xpath("//span[@class='fake-menu-button']/button[@class='fake-menu-button__button expand-btn expand-btn--small expand-btn--secondary']/span[@class='expand-btn__cell']"));
        WebElement page = driver.findElement(By.xpath("//a[@href='https://www.ebay.com/sch/i.html?_from=R40&_nkw=Java+for+dummies&_sacat=0&_ipg=200']"));
        pageBtn.click();
        page.click();
        //amazonsearch.waitFor(3);
        List<WebElement> searchLinks = driver.findElements(By.xpath("//ul[@class='srp-results srp-list clearfix']//h3[@class='s-item__title']/parent::a/following-sibling::div//child::span[@class='s-item__price']"));
        double totalPrice = 0;
        double totalPrice1 = 0;

        Thread.sleep(2000);
        for (WebElement price : searchLinks) {
            String productPrice = price.getAttribute("innerText").substring(1,5);
            double productPriceDouble0 = Double.parseDouble(productPrice);
            totalPrice += productPriceDouble0;
        }
        WebElement pageTwo = driver.findElement(By.xpath("//ol[@class='pagination__items']/li/following-sibling::li"));
        pageTwo.click();

        Thread.sleep(2000);
        List<WebElement> searchLinks1 = driver.findElements(By.xpath("//ul[@class='srp-results srp-list clearfix']//h3[@class='s-item__title']/parent::a/following-sibling::div//child::span[@class='s-item__price']"));
        for (WebElement price : searchLinks1) {
            String productPrice = price.getAttribute("innerText").substring(1,5);
            double productPriceDouble0 = Double.parseDouble(productPrice);
            totalPrice1 += productPriceDouble0;
        }
        double finalResult = totalPrice+totalPrice1;
        System.out.println("Total count of prices: " + finalResult);
    }
}


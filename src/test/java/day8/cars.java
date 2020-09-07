package day8;

import day6.amazonsearch;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class cars {

    @Test
    public void test2() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://cars.com");
        amazonsearch.waitFor(2);

        WebElement stockType = driver.findElement(By.xpath("//select[@name='stockType']"));
        Select selectStockType = new Select(stockType);
        selectStockType.selectByVisibleText("New Cars");

        WebElement makeId = driver.findElement(By.xpath("//select[@name='makeId']"));
        Select selectMakeId = new Select(makeId);
        selectMakeId.selectByVisibleText("Toyota");

        WebElement modelId = driver.findElement(By.xpath("//select[@name='modelId']"));
        Select selectModelId = new Select(modelId);
        selectModelId.selectByVisibleText("Camry");

        WebElement priceMax = driver.findElement(By.xpath("//select[@name='priceMax']"));
        Select selectPriceMax = new Select(priceMax);
        selectPriceMax.selectByValue("40000");

        WebElement radiusMiles = driver.findElement(By.xpath("//select[@name='radius']"));
        Select selectRadius = new Select(radiusMiles);
        selectRadius.selectByValue("10");

        WebElement inputZip = driver.findElement(By.xpath("//input[@type='tel']"));
        inputZip.clear();
        inputZip.sendKeys("60056");

        driver.findElement(By.xpath("//input[@type='submit']")).click();
        amazonsearch.waitFor(3);

        List<WebElement> searchResult = driver.findElements(By.xpath("//span[@class='listing-row__price ']"));
        List<WebElement> searchTitle = driver.findElements(By.xpath("//div[@class='shop-srp-listings__inner']//h2"));
        List<WebElement> searchRadius = driver.findElements(By.xpath("//div[@class='shop-srp-listings__inner']//div[@class='listing-row__distance ']"));


        for (WebElement price : searchResult) {
            String productPrice = price.getAttribute("innerText").replace(",", "").substring(1);
            double productPriceDouble = Double.parseDouble(productPrice);
            Assert.assertTrue(productPriceDouble <= 40000);
        }
        for (WebElement title : searchTitle) {
            String productTitle = title.getText().toLowerCase();
            Assert.assertTrue(productTitle.contains("toyota"));
            Assert.assertTrue(productTitle.contains("camry"));
        }
        for (WebElement radius : searchRadius) {
            String productRadius = radius.getText();
            String[] splittedRadius = productRadius.split(" ");
            int splittedRadiusMiles = Integer.parseInt(splittedRadius[0]);
            int splittedRadiusZip = Integer.parseInt(splittedRadius[3]);
            Assert.assertEquals(60056, splittedRadiusZip);
            Assert.assertTrue(splittedRadiusMiles <= 50);
        }
    }
}

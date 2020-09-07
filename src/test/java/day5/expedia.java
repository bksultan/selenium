package day5;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class expedia {
    @Test
    public void flightSearch() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.expedia.com/");
        String title = driver.getTitle();
        String expectedTitle = "Expedia Travel: Search Hotels, Cheap Flights, Car Rentals & Vacations";
        Assert.assertEquals("Expected title was not found", expectedTitle, title);
        WebElement flightsTab = driver.findElement(By.xpath("//a[@href='?pwaLOB=wizard-flight-pwa']"));
        flightsTab.click();
        WebElement oneWayButton = driver.findElement(By.xpath("//a[@href='/?pwaLob=wizard-flight-pwa&pwaSubLOB=oneway']"));
        oneWayButton.click();
        WebElement leavingFromButton = driver.findElement(By.xpath("//button[@aria-label='Leaving from']"));
        leavingFromButton.click();
        WebElement leavingFromField = driver.findElement(By.id("location-field-leg1-origin"));
        leavingFromField.sendKeys("Chicago, IL" + Keys.ENTER);
        WebElement goingToButton = driver.findElement(By.xpath("//button[@aria-label='Going to']"));
        goingToButton.click();
        WebElement goingToField = driver.findElement(By.id("location-field-leg1-destination"));
        goingToField.sendKeys("New York, NY" + Keys.ENTER);
        WebElement dateButton = driver.findElement(By.id("d1-btn"));
        dateButton.click();
        Thread.sleep(2000);
        WebElement departureDate = driver.findElement(By.xpath("//button[@aria-label='Aug 20, 2020']"));
        departureDate.click();
        WebElement doneButton = driver.findElement(By.xpath("//button[@data-stid='apply-date-picker']"));
        doneButton.click();
        WebElement searchButton = driver.findElement(By.xpath("//button[text()='Search']"));
        searchButton.click();
    }
}

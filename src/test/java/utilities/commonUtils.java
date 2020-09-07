package utilities;

import com.sun.org.apache.xerces.internal.xs.StringList;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import static utilities.constants.*;

public class commonUtils {

    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void switchToWindow(){
        WebDriver driver = driverUtils.getDriver(BROWSER);
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        String currentWindowHandle = driver.getWindowHandle();
        while (iterator.hasNext()){
            String newHandle = iterator.next();
            if (!newHandle.equalsIgnoreCase(currentWindowHandle)){
                driver.switchTo().window(newHandle);
            }
        }
    }

    public static void takeScreenshot(WebDriver driver, String testName) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destination = "src/test/java/screenshotFile/" + testName + System.currentTimeMillis() + ".png";
        File destScreenshot = new File(destination);
        FileUtils.copyFile(screenshot, destScreenshot);
    }

    public static Properties readPropertyFile(String pathToPropertyFile) throws IOException {
        Properties properties = new Properties();
        File propFile = new File(pathToPropertyFile);
        FileInputStream fileInputStream = new FileInputStream(propFile);
        properties.load(fileInputStream);

        return properties;
    }

    public static String getProperty(String key) {
        try {
            Properties properties = readPropertyFile("src/test/resources/credentials.properties");
            String value = properties.getProperty(key);
            return value;
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static WebElement fluentWait(int duration, int pollingTime, By locator) {
        Wait<WebDriver> fluentWait = new FluentWait<>(driverUtils.getDriver(getProperty(BROWSER)))
                .withTimeout(Duration.ofSeconds(duration)) //wait for 30 sec
                .pollingEvery(Duration.ofSeconds(pollingTime)) //check every 3 sec
                .ignoring(NoSuchElementException.class); //ignore NoSuchElementException

        WebElement element = fluentWait.until(driver -> driver.findElement(locator));
        return element;
    }

    public static WebElement visibilityOfElement(int timeOut, By locator) {
        WebDriverWait wait = new WebDriverWait(driverUtils.getDriver(getProperty(BROWSER)), timeOut);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }

    public static WebElement elementToBeClickable(int timeOut, By locator) {
        WebDriverWait wait = new WebDriverWait(driverUtils.getDriver(getProperty(BROWSER)), timeOut);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        return element;
    }

    public static void waitForTitle(int timeOut, String title) {
        WebDriverWait wait = new WebDriverWait(driverUtils.getDriver(getProperty(BROWSER)), timeOut);
        wait.until(ExpectedConditions.titleIs(title));
    }
}

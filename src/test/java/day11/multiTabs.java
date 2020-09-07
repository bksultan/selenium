package day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class multiTabs {
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
    public void multiTab() {
        driver.get("https://www.google.com/");
        WebElement searchInput = driver.findElement(By.xpath("//input[@name='q']"));
        actions.keyDown(Keys.SHIFT).sendKeys(searchInput, "Selenium Cookbook" + Keys.ENTER).keyUp(Keys.SHIFT).perform();
        WebElement link = driver.findElement(By.xpath("//a[@href='https://www.amazon.com/Selenium-Testing-Cookbook-Gundecha-Unmesh/dp/1849515743']"));

        String currentWindowHandle = driver.getWindowHandle();
        System.out.println("Current window handle id: " + currentWindowHandle);

        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println("All window handles id: " + allWindowHandles);

        actions.keyDown(Keys.CONTROL).click(link).keyUp(Keys.CONTROL).perform();

        Set<String> allWindowHandles1 = driver.getWindowHandles();
        System.out.println("All window handles id: " + allWindowHandles1);

        for (String handle : allWindowHandles1) {
            if (handle.equalsIgnoreCase(currentWindowHandle)) {
                System.out.println(handle + " is a window handle for an old window");
            } else if (!handle.equalsIgnoreCase(currentWindowHandle)) {
                System.out.println(handle + " is a window handle for a NEW window");
            }
        }
    }
}

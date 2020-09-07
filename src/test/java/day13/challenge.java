package day13;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class challenge {
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
    public void test1() {
        driver.get("http://automationpractice.com/index.php");

        String itemPath = "//ul[@id='homefeatured']//li[contains(@class, 'ajax_block_product')]";
        String nameItemPath = "//div[@class='right-block']//a[@class='product-name']";

        WebElement nameOfProduct = driver.findElement(By.xpath(itemPath + nameItemPath));

        Actions actions = new Actions(driver);
        actions.moveToElement(nameOfProduct).perform();

        WebElement quickView = driver.findElement(By.xpath("//ul[@id='homefeatured']//li[contains(@class, 'ajax_block_product')]//div[@class='product-image-container']//a[@href='http://automationpractice.com/index.php?id_product=1&controller=product']/span"));
        actions.click(quickView).perform();
        driver.switchTo().frame(1);
        WebElement header = driver.findElement(By.xpath("//h1[@itemprop]"));
        String validate = "Faded Short Sleeve T-shirts";
        System.out.println(header.getText());
        Assert.assertEquals(validate.toLowerCase(), header.getText().toLowerCase());
        driver.switchTo().defaultContent();
        WebElement close = driver.findElement(By.xpath("//a[@title='Close']"));
        actions.click(close).perform();
    }
    @Test
    public void nestedIFrame() {
        driver.get("https://the-internet.herokuapp.com/");
        WebElement iFrame = driver.findElement(By.xpath("//a[@href='/frames']"));
        actions.keyDown(Keys.CONTROL).click(iFrame).keyUp(Keys.CONTROL).perform();

        String windowName = driver.getWindowHandle();
        Set<String> windowNames = driver.getWindowHandles();
        String secondWindowName = "";
        for (String name : windowNames) {
            if (!name.equals(windowName)) {
                secondWindowName = name;
                driver.switchTo().window(windowName);
            }
        }
        driver.switchTo().window(secondWindowName);
        WebElement nested = driver.findElement(By.xpath("//a[@href='/nested_frames']"));

        Action actionChain = actions.keyDown(Keys.CONTROL).click(nested).keyUp(Keys.CONTROL).build();
        actionChain.perform();

        Set<String> windows2 = driver.getWindowHandles();
        Assert.assertEquals(windows2.size(), 3, "Invalid number of windows open");

        String thirdWindowName = "";
        for (String handle : windows2) {
            if (!handle.equals(windows2) && !handle.equals(secondWindowName) ) {
                thirdWindowName = handle;
                driver.switchTo().window(windowName);
            }
        }

        driver.switchTo().window(thirdWindowName);
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        WebElement middleElement = driver.findElement(By.xpath("//div[@id='content']"));
        System.out.println(middleElement.getText());
        Assert.assertEquals(middleElement.getText(), "MIDDLE");
    }
}

package day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MouseActions {
    WebDriver driver;
    Actions actions;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        actions = new Actions(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void navigateToPage() {

    }

    @AfterMethod
    public void teardown() {
        //driver.quit();
    }

    @Test
    public void mouseClick() {
        driver.get("https://the-internet.herokuapp.com/");
        WebElement dragAndDropLink = driver.findElement(By.xpath("//a[@href='/drag_and_drop']"));
        actions.click(dragAndDropLink).perform();
    }

    @Test
    public void rightMouseClick() {
        driver.get("https://the-internet.herokuapp.com/");
        WebElement contextMenu = driver.findElement(By.xpath("//a[@href='/context_menu']"));
        actions.click(contextMenu).perform();
        WebElement contextMenuElement = driver.findElement(By.id("hot-spot"));
        actions.contextClick(contextMenuElement).perform();
    }

    @Test
    public void hoverOver() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/");
        WebElement contextMenu = driver.findElement(By.xpath("//a[@href='/hovers']"));
        actions.click(contextMenu).perform();

        WebElement user1 = driver.findElement(By.xpath("//a[@href='/users/1']/parent::div/parent::div"));
        WebElement user1Title = driver.findElement(By.xpath("//a[@href='/users/1']/parent::div/h5"));
        WebElement user1Link = driver.findElement(By.xpath("//a[@href='/users/1']"));

        Assert.assertFalse(user1Link.isDisplayed());
        Assert.assertFalse(user1Title.isDisplayed());

        Thread.sleep(2000);
        actions.moveToElement(user1).perform();
        Thread.sleep(2000);

        Assert.assertTrue(user1Title.isDisplayed());
        Assert.assertTrue(user1Link.isDisplayed());
    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/");
        WebElement contextMenu = driver.findElement(By.xpath("//a[@href='/drag_and_drop']"));
        actions.click(contextMenu).perform();

        WebElement linkA = driver.findElement(By.id("column-a"));
        WebElement linkB = driver.findElement(By.id("column-b"));
        Thread.sleep(2000);
        actions.clickAndHold(linkA).perform();
        actions.moveByOffset(262, 0).release().perform();
    }

    @Test
    public void dragAndDrop1() throws InterruptedException {
        driver.get("https://amazon.com/");
        WebElement linkA = driver.findElement(By.id("twotabsearchtextbox"));
        Thread.sleep(2000);
        linkA.click();
        linkA.sendKeys(Keys.chord(Keys.CONTROL, "v"));
    }

    @Test
    public void horizontalSlider() {
        driver.get("https://the-internet.herokuapp.com/");
        WebElement horizontalSlider = driver.findElement(By.xpath("//a[@href='/horizontal_slider']"));
        actions.click(horizontalSlider).perform();

        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
        actions.clickAndHold(slider).dragAndDropBy(slider, -10, 0).perform();
    }
}

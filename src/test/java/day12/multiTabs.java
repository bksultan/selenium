package day12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        driver.get("https://the-internet.herokuapp.com/");
        WebElement checkboxesLink = driver.findElement(By.xpath("//a[@href='/checkboxes']"));
        WebElement frameLink = driver.findElement(By.xpath("//a[@href='/frames']"));
        actions.keyDown(Keys.CONTROL).click(checkboxesLink).keyUp(Keys.CONTROL).perform();

        //getting the name of tab/window where driver can perform actions
        String windowName = driver.getWindowHandle();
        Set<String> windowNames = driver.getWindowHandles();
        String secondWindowName = "";

        for (String name : windowNames) {
            if (!name.equals(windowName)){
                secondWindowName = name;
            }
        }
        driver.switchTo().window(secondWindowName);

        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        checkboxes.get(0).click();
        Assert.assertTrue(checkboxes.get(0).isSelected());
        Assert.assertTrue(checkboxes.get(1).isSelected());

        driver.close();
        driver.switchTo().window(windowName);
        actions.keyDown(Keys.CONTROL).click(frameLink).keyUp(Keys.CONTROL).perform();
    }
    @Test
    public void multiTab1() {
        driver.get("https://the-internet.herokuapp.com/");
        WebElement checkboxesLink = driver.findElement(By.xpath("//a[@href='/checkboxes']"));
        actions.keyDown(Keys.COMMAND).click(checkboxesLink).keyUp(Keys.COMMAND).perform();
        Map<String, String> linksAndHandles = new HashMap<>();
        //getting the name of tab/window where driver can perform actions
        String windowName = driver.getWindowHandle();
        Set<String> windowNames = driver.getWindowHandles();
        String secondWindowName = "";
        for (String name : windowNames) {
            if (!name.equals(windowName)) {
                secondWindowName = name;
            }
        }
        WebElement mainPageHeader = driver.findElement(By.tagName("//h1"));
        String mainPageHeaderString = mainPageHeader.getText();
        linksAndHandles.put(mainPageHeaderString, windowName);
        linksAndHandles.put("checkboxesPage", secondWindowName);
        WebElement framesLink = driver.findElement(By.xpath("//a[@href='/frames']"));
        actions.keyDown(Keys.COMMAND).click(framesLink).keyUp(Keys.COMMAND).perform();
        Set<String> windowNames2 = driver.getWindowHandles();
        String thirdWindowName = "";
        for (String name : windowNames2) {
            if (!name.equals(windowName) && !name.equals(secondWindowName)) {
                thirdWindowName = name;
            }
        }
        linksAndHandles.put("framesPage", thirdWindowName);
        WebElement floatingMenuLink = driver.findElement(By.xpath("//a[@href='/floating_menu']"));
        actions.keyDown(Keys.COMMAND).click(floatingMenuLink).keyUp(Keys.COMMAND).perform();
        Set<String> windowNames3 = driver.getWindowHandles();
        String fourthWindowName = "";
        for (String name : windowNames3){
            if (!name.equals(windowName) && !name.equals(secondWindowName) && !name.equals(thirdWindowName)){
                fourthWindowName = name;
            }
        }
        linksAndHandles.put("floatingWindowPage", fourthWindowName);
        System.out.println(linksAndHandles);
    }
}
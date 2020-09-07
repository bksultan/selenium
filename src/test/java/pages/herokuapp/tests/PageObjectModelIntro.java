package pages.herokuapp.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.herokuapp.ABTestPage;
import pages.herokuapp.HomePage;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class PageObjectModelIntro {
    WebDriver driver;
    Actions actions;
    HomePage homePage;
    ABTestPage abTestPage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        actions = new Actions(driver);
        homePage = new HomePage(driver);
        abTestPage = new ABTestPage(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void test1() {
        driver.get("https://the-internet.herokuapp.com/");
        HomePage homePage = new HomePage(driver);
        homePage.abTestLink.click();
    }

    @Test
    public void test2() {
        driver.get("https://the-internet.herokuapp.com/");
        actions.keyDown(Keys.SHIFT).click(homePage.abTestLink).keyUp(Keys.SHIFT).perform();

        /* Change a window of browser */
        String window1 = driver.getWindowHandle();
        String window2 = "";
        Set<String> allWindows = driver.getWindowHandles();
        for (String handle : allWindows) {
            if (!handle.equals(window1)) {
                window2 = handle;
            }
        }
        driver.switchTo().window(window2);

        Assert.assertTrue(abTestPage.abTestHeaderText.getText().startsWith("A/B Test"));

        String text = abTestPage.abTestParagraph.getText();
        String[] splittedText = text.split(" ");
        Assert.assertTrue(splittedText.length > 10);
    }
}

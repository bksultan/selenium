package day7;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxDriver {
    @Test
    public void testWithFirefox() {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.ebay.com/");
    }
}

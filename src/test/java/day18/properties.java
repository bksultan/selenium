package day18;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.IOException;
import java.util.Properties;

import static utilities.constants.*;

public class properties extends TestBase {
    OpenEmrHomePage OpenEmrHomePage;

    @Test
    public void loginTest() throws IOException {
        OpenEmrHomePage = new day18.OpenEmrHomePage(driver);

        Properties properties = utilities.commonUtils.readPropertyFile("src/test/resources/credentials.properties");

        String url = properties.getProperty(URL);
        driver.get(url);

        String username = properties.getProperty(USERNAME);
        OpenEmrHomePage.username.sendKeys(username);

        String password = properties.getProperty(PASSWORD);
        OpenEmrHomePage.password.sendKeys(password);
    }
}

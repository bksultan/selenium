package projectDay.Project4.object;

import org.testng.annotations.Test;
import projectDay.Project4.pages.orangeHRMLive;
import utilities.TestBase;
import utilities.constants;

import java.io.IOException;
import java.util.Properties;

public class AddNewUserObject extends TestBase {
    orangeHRMLive orangeHRMLive;

    @Test
    public void AddNewUserObjectTest() throws IOException {
        orangeHRMLive = new orangeHRMLive(driver);
        Properties properties = utilities.commonUtils.readPropertyFile("src/test/resources/credentials.properties");

        String url = properties.getProperty(constants.URL);
        driver.get(url);
        String username = properties.getProperty(constants.USERNAME);
        orangeHRMLive.username.sendKeys(username);
        String password = properties.getProperty(constants.PASSWORD);
        orangeHRMLive.password.sendKeys(password);

        orangeHRMLive.submitButton.click();
        orangeHRMLive.adminTab.click();

        orangeHRMLive.addName.click();
        orangeHRMLive.nameInput.sendKeys("Beksultan Ismatov");
        orangeHRMLive.userNameInput.sendKeys("BkSultan");
    }
}
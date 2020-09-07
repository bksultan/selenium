package projectDay.Project4.object;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import projectDay.Project4.pages.orangeHRMLive;
import utilities.TestBase;
import utilities.constants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class LoginTestObject extends TestBase {
    orangeHRMLive orangeHRMLive;

    @Test
    public void LoginTestObjectTest() throws IOException {
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
        orangeHRMLive.checkbox.click();

        for (WebElement checkedCheckboxes : orangeHRMLive.checkboxes) {
            Assert.assertTrue(checkedCheckboxes.isSelected());
        }

        orangeHRMLive.checkbox.click();

        orangeHRMLive.nameListSort.click();

        for (WebElement nameList : orangeHRMLive.names) {
            System.out.println(nameList.getText());
        }
    }
}

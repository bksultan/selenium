package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class TestBase {
    protected WebDriver driver;

//    @BeforeClass
//    public void setup() { driver = driverUtils.getDriver("chrome");}

    @BeforeMethod
    @Parameters({"browser"})
    public void setup(String browserType) {
        driver = driverUtils.getDriver(browserType);
    }
}

package day9;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class Before {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        System.out.println("Printing before class");
    }

    @BeforeMethod
    public void setTest() {
        System.out.println("Printing before method");
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }

    @AfterMethod
    public void AfterMethod() {
        System.out.println("After Method");
    }

    @Test
    public void test1() {
        System.out.println("Printing before test1");
    }

    @Test
    public void test2() {
        System.out.println("Printing before test2");
    }

    @Test
    public void test3() {
        System.out.println("Printing before test3");
    }

}

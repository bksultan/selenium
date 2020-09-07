package day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class softAssert {

    @Test
    public void test1() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("Techtorial", "google");
        softAssert.assertTrue(1 > 5);
        softAssert.assertTrue(0 == 0);
        softAssert.assertTrue(5 == 0);
        /*Check all soft Asserts*/
        softAssert.assertAll();
    }

    @Test
    public void test2() {
        Assert.assertEquals("Techtorial", "google");
    }
}

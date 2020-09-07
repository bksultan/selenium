package testNGAdv;

import org.testng.annotations.Test;

public class priority {
    @Test
    public void goodTest() {
        System.out.println("Print out from goodTest");
    }
    @Test
    public void badTest() {
        System.out.println("Print out from badTest");
    }
    @Test
    public void bestTest() {
        System.out.println("Print out from bestTest");
    }
    @Test
    public void worstTest() {
        System.out.println("Print out from worstTest");
    }
    @Test(enabled = false)
    public void neverPassedTest() {
        System.out.println("Print out from neverPassedTest");
    }
}

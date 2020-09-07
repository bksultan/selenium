package day17.testNGAdv;

import org.testng.annotations.Test;

public class testNGParallel {
    @Test
    public void test1() {
        System.out.println("Test 1 run");
        utilities.commonUtils.waitFor(2);
    }

    @Test
    public void test2() {
        System.out.println("Test 2 run");
        utilities.commonUtils.waitFor(2);
    }

    @Test
    public void test3() {
        System.out.println("Test 3 run");
        utilities.commonUtils.waitFor(2);
    }

    @Test
    public void test4() {
        System.out.println("Test 4 run");
        utilities.commonUtils.waitFor(2);
    }
}

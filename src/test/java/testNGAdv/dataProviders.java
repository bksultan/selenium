package testNGAdv;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProviders {
    @Test(dataProvider = "numbersTest")
    public void test1(String dataFromProvider, int dataFromProvider1) {
        System.out.println(dataFromProvider);
        System.out.println(dataFromProvider1);
    }

    @DataProvider(name = "numbersTest")
    public static Object[][] numbers() {
        return new Object[][]{{"element1", 32}, {"element2", 343}, {"element3", 8909}};
    }
}

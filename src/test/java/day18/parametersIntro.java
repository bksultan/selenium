package day18;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class parametersIntro {


    @Test
    @Parameters({"username", "password"})
    public void test1(String customUsername, String customPassword){
        System.out.println(customUsername);
        System.out.println(customPassword);

    }
}

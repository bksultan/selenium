package day9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomeWork {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://letskodeit.teachable.com/p/practice");
    }

    @Test
    public void test1() {
        List<WebElement> allInputs = driver.findElements(By.xpath("//input[@name='cars']"));
        List<String> radioList = new ArrayList<String>();
        List<String> checkboxList = new ArrayList<String>();

        for (int i = 0; i < allInputs.size(); i++) {
            String printTxt = allInputs.get(i).getAttribute("type");
            if (printTxt.contains("radio")) {
                radioList.add(printTxt);
            }
            if (printTxt.contains("checkbox")) {
                checkboxList.add(printTxt);
            }
        }
        System.out.println("Radio Inputs: " + radioList);
        System.out.println("Checkbox Inputs: " + checkboxList);
    }

    @Test
    public void test2() {
        List<WebElement> listOfCars = driver.findElements(By.xpath("//input[@name='cars']"));
        List<WebElement> radioList = new ArrayList<>();
        List<WebElement> checkboxList = new ArrayList<>();
        for (WebElement car : listOfCars) {
            String typeAttribute = car.getAttribute("type");
            if (typeAttribute.equalsIgnoreCase("radio")) {
                radioList.add(car);
            } else {
                checkboxList.add(car);
            }
            switch (typeAttribute){
                case "radio":
                    radioList.add(car);
                    break;
                case "checkbox":
                    checkboxList.add(car);
                    break;
                default:
                    throw new RuntimeException("Unsupported web element");
            }
        }
        System.out.println("radio btn size: "+radioList.size());
        System.out.println("checkbox btn size: "+checkboxList.size());

    }
}

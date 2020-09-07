package day20;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class fluentWait {
    @Test
    public void test1() {
        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.get("https://ebay.com");

        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15)) //wait for 30 sec
                .pollingEvery(Duration.ofSeconds(3)) //check every 3 sec
                .ignoring(NoSuchElementException.class); //ignore NoSuchElementException

        WebElement newSearchFiled = fluentWait.until(driver1 -> driver1.findElement(By.id("gh-ac")));
        newSearchFiled.sendKeys("java");
    }

    @Test
    public void test2() {
        IntStream.range(0, 50).filter(myN -> myN % 2 == 0).forEach(myNumber -> System.out.println(" " + myNumber));

        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("bye");
        list.add("world");
        list.add("kid");
        list.add("helicopter");

        System.out.println("Printing with forLoop");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() > 4) {
                System.out.println(list.get(i));
            }
        }

        System.out.println("Printing with lambda");
        list.stream().filter(word -> word.length()>4).forEach(System.out::println);
    }
}

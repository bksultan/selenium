package day6;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class amazonsearch {
    @Test
    public void test1(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  // connect to chromedriver
        WebDriver driver = new ChromeDriver();                              // open the browser
        driver.manage().window().maximize();
        driver.navigate().to("https://amazon.com/");

        driver.findElement(By.id("twotabsearchtextbox"))
                .sendKeys("Java for dummies" + Keys.ENTER);
        List<WebElement> links = driver.findElements(By.xpath("//h2/child::a[@class='a-link-normal a-text-normal']"));
        List<WebElement> linksRate = driver.findElements(By.xpath("//span[@class='a-icon-alt']"));
        waitFor(3);
        for (int i = 0; i < links.size(); i++) {
            System.out.println(links.get(i).getText());
            System.out.println(linksRate.get(i).getAttribute("innerText"));
        }
    }

    @Test
    public void search4(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  // connect to chromedriver
        WebDriver driver = new ChromeDriver();                              // open the browser
        driver.manage().window().maximize();
        driver.navigate().to("https://amazon.com/");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java for dummies" + Keys.ENTER);
        List<WebElement> linksRate = driver.findElements(By.xpath("//span[@class='a-icon-alt']"));
        List<WebElement> links = driver.findElements(By.xpath("//span[@class='a-icon-alt']/../../../../../../preceding-sibling::div[@class='a-section a-spacing-none']/h2/a"));



        for (int i = 0; i < linksRate.size(); i++) {
                String ratingText = linksRate.get(i).getAttribute("innerText");
                String[] splittedResult = ratingText.split(" ");
                double rating = Double.parseDouble(splittedResult[0]);
                double minRate = 4.6;
                if (rating > minRate) {
                    System.out.println(links.get(i).getText());
                    System.out.println(ratingText);
                }
            }
    }

    public static void waitFor(int seconds){
        try{
            Thread.sleep(seconds*1000);
        }catch (InterruptedException ex){
            System.out.println("Caught an Interrupted Exception" +ex);
        }
    }

}

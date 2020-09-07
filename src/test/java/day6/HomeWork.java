package day6;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork {
    @Test
    public void adv1() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  // connect to chromedriver
        WebDriver driver = new ChromeDriver();                              // open the browser
        driver.manage().window().maximize();
        driver.navigate().to("https://getbootstrap.com/docs/4.5/layout/overview/");

        WebElement testLink = driver.findElement(By.xpath("//table[@class='table text-left']/tbody"));
        String rowTable = testLink.getAttribute("innerHTML");
        System.out.println(rowTable.replaceAll("<td>", ""));

        /*WebDriver driver = new ChromeDriver();                              // open the browser
        driver.manage().window().maximize();
        driver.navigate().to("https://amazon.com");

        WebElement testLink = driver.findElement(By.id("twotabsearchtextbox"));
        String rowTable = testLink.getAttribute("autocomplete");
        System.out.println(rowTable);

        WebElement testLink1 = driver.findElement(By.id("nav-xshop-container"));
        String rowTable1 = testLink1.getAttribute("innerHTML");
        System.out.println(rowTable1);

        WebElement testLink2 = driver.findElement(By.xpath("//ul[@class='a-unordered-list a-horizontal a-size-small']"));
        String rowTable2 = testLink2.getAttribute("innerText");
        System.out.println(rowTable2);*/
    }
}

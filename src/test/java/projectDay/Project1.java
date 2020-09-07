package projectDay;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Project1 {
    @Test
    public void test1() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  // connect to chromedriver
        WebDriver driver = new ChromeDriver();                              // open the browser
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        String title = driver.getTitle();
        Assert.assertEquals("Web Orders Login", title);

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");

        driver.findElement(By.xpath("//input[@type='submit']")).click();
        String title2 = driver.getTitle();
        Assert.assertEquals("Web Orders", title2);

        String defaultUrl = driver.getCurrentUrl();
        Assert.assertNotEquals("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Default.aspx", defaultUrl);

        WebElement header = driver.findElement(By.tagName("h2"));
        Assert.assertEquals("List of All Orders", header.getText());
        driver.close();
    }

    @Test
    public void test2() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  // connect to chromedriver
        WebDriver driver = new ChromeDriver();                              // open the browser
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        String title = driver.getTitle();
        Assert.assertEquals("Web Orders Login", title);

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        driver.findElement(By.xpath("//a[@href='Products.aspx']")).click();

        WebElement selectedLi = driver.findElement(By.xpath("//li[2]"));
        String linkattr = selectedLi.getAttribute("class");
        System.out.println(linkattr);
        Assert.assertTrue(linkattr.contains("selected"));

        WebElement header = driver.findElement(By.tagName("h2"));
        Assert.assertEquals("List of Products", header.getText());
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("Products"));
        driver.close();
    }
    @Test
    public void test3() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  // connect to chromedriver
        WebDriver driver = new ChromeDriver();                              // open the browser
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        String title = driver.getTitle();
        Assert.assertEquals("Web Orders Login", title);

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        WebElement link1 = driver.findElement(By.xpath("//a[@href='Default.aspx']"));
        WebElement link2 = driver.findElement(By.xpath("//a[@href='Products.aspx']"));
        WebElement link3 = driver.findElement(By.xpath("//a[@href='Process.aspx']"));

        String linkOne = link1.getAttribute("href");
        String linkTwo = link2.getAttribute("href");
        String linkThree = link3.getAttribute("href");

        Assert.assertTrue(linkOne.contains("Default.aspx"));
        Assert.assertTrue(linkTwo.contains("Products.aspx"));
        Assert.assertTrue(linkThree.contains("Process.aspx"));
        driver.close();
    }
    @Test
    public void test4() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  // connect to chromedriver
        WebDriver driver = new ChromeDriver();                              // open the browser
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        String title = driver.getTitle();
        Assert.assertEquals("Web Orders Login", title);

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.findElement(By.xpath("//a[@href='Process.aspx']")).click();

        driver.findElement(By.xpath("//option[@value='ScreenSaver']")).click();
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"))
                .sendKeys("5" + Keys.ENTER);
        String name = "Techtorial Academy";
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"))
                .sendKeys(name + Keys.ENTER);

        String address = "2200 Edevon";
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"))
                .sendKeys(address + Keys.ENTER);

        String address1 = "Des Plaines";
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"))
                .sendKeys(address1 + Keys.ENTER);

        String address2 = "Illinois";
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4"))
                .sendKeys(address2 + Keys.ENTER);

        String address3 = "60018";
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"))
                .sendKeys(address3 + Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_1")).click();

        String cardNum = "444993876233";
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6"))
                .sendKeys(cardNum + Keys.ENTER);

        String cardExp = "03/21";
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1"))
                .sendKeys(cardExp + Keys.ENTER);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();

        WebElement order = driver.findElement(By.tagName("strong"));
        Assert.assertEquals("New order has been successfully added.", order.getText());
        driver.findElement(By.xpath("//a[@href='Default.aspx']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//table[@class='SampleTable']//tr[2]//td[2]")).getText(), name);
        Assert.assertEquals(driver.findElement(By.xpath("//table[@class='SampleTable']//tr[2]//td[6]")).getText(), address);
        Assert.assertEquals(driver.findElement(By.xpath("//table[@class='SampleTable']//tr[2]//td[7]")).getText(), address1);
        Assert.assertEquals(driver.findElement(By.xpath("//table[@class='SampleTable']//tr[2]//td[8]")).getText(), address2);
        Assert.assertEquals(driver.findElement(By.xpath("//table[@class='SampleTable']//tr[2]//td[9]")).getText(), address3);
        Assert.assertEquals(driver.findElement(By.xpath("//table[@class='SampleTable']//tr[2]//td[11]")).getText(), cardNum);
        Assert.assertEquals(driver.findElement(By.xpath("//table[@class='SampleTable']//tr[2]//td[12]")).getText(), cardExp);

        driver.close();
    }
}

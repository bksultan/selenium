package projectDay;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Project2 {
    @Test
    public void test1() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");

        WebElement cartTextElement = driver.findElement(By.xpath("//span[@class='ajax_cart_no_product']"));
        String cartText = cartTextElement.getText();
        Assert.assertEquals("Not the same", "(empty)", cartText);


        String itemPath = "//ul[@id='homefeatured']//li[contains(@class, 'ajax_block_product')]";
        String pricePath = "//div[@class='right-block']//span[@itemprop='price']";
        String nameItemPath = "//div[@class='right-block']//a[@class='product-name']";
        String oldPricePath = "//div[@class='right-block']//span[@class='old-price product-price']";
        String discountRate = "//div[@class='right-block']//span[@class='price-percent-reduction']";

        double emptyMin = 1000000;
        int index = 0;

        List<WebElement> allItems = driver.findElements(By.xpath(itemPath));
        for (int i = 1; i < allItems.size() + 1; i++) {
            String fullPricePath = itemPath + "[" + i + "]" + pricePath;
            WebElement price = driver.findElement(By.xpath(fullPricePath));
            String strPrice = price.getText().replace("$", "");
            double dbPrice = Double.parseDouble(strPrice);

            if (dbPrice < emptyMin) {
                emptyMin = dbPrice;
                index = i;
            }
        }
        String nameOfLessItem = itemPath + "[" + index + "]" + nameItemPath;
        WebElement nameOfProduct = driver.findElement(By.xpath(nameOfLessItem));
        System.out.println(nameOfProduct.getText());
        WebElement oldPrice = driver.findElement(By.xpath(itemPath + "[" + index + "]" + oldPricePath));
        System.out.println(oldPrice.getText());
        WebElement discount = driver.findElement(By.xpath(itemPath + "[" + index + "]" + discountRate));
        System.out.println(discount.getText());

        double dbOldPrice = Double.parseDouble(oldPrice.getText().substring(1));
        double dbDiscount = Double.parseDouble(discount.getText().substring(1, discount.getText().length() - 1));
        double result = dbOldPrice * (dbDiscount / 100);
        System.out.println(result);
        Assert.assertTrue(dbOldPrice - result == emptyMin);
    }

    @Test
    public void test2() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");

        String itemPath = "//ul[@id='homefeatured']//li[contains(@class, 'ajax_block_product')]";
        String pricePath = "//div[@class='right-block']//span[@itemprop='price']";
        String nameItemPath = "//div[@class='right-block']//a[@class='product-name']";
        String oldPricePath = "//div[@class='right-block']//span[@class='price product-price']";
        String priceAfterMoreBtnStr = "//span[@id='our_price_display']";
        String nameAfterMoreBtnStr = "//h1[@itemprop='name']";

        double emptyMin = 0;
        int index = 0;

        List<WebElement> allItems = driver.findElements(By.xpath(itemPath));
        for (int i = 1; i < allItems.size(); i++) {
            String fullPricePath = itemPath + "[" + (i + 1) + "]" + pricePath;
            WebElement price = driver.findElement(By.xpath(fullPricePath));
            String strPrice = price.getText().replace("$", "");
            double dbPrice = Double.parseDouble(strPrice);

            if (dbPrice > emptyMin) {
                emptyMin = dbPrice;
                index = i;
            }
        }
        String nameOfMostItem = itemPath + "[" + index + "]" + nameItemPath;
        String priceOfMostItem = itemPath + "[" + index + "]" + oldPricePath;
        WebElement priceOfProduct = driver.findElement(By.xpath(priceOfMostItem));
        WebElement nameOfProduct = driver.findElement(By.xpath(nameOfMostItem));
        String nameOfProductStr = nameOfProduct.getText();
        String priceOfProductTxt = priceOfProduct.getText();

        Actions actions = new Actions(driver);
        actions.moveToElement(nameOfProduct).perform();
        String moreButtonPath = "//span[contains(text(),'More')]";
        String fullMoreButtonPath = itemPath + "[" + index + "]" + moreButtonPath;
        WebElement moreButton = driver.findElement(By.xpath(fullMoreButtonPath));
        actions.moveToElement(moreButton).click().perform();

        WebElement priceAfterMoreBtn = driver.findElement(By.xpath(priceAfterMoreBtnStr));
        String priceAfterMoreBtnTxt = priceAfterMoreBtn.getText();
        Assert.assertEquals("Not Match", priceAfterMoreBtnTxt, priceOfProductTxt);

        WebElement nameAfterMoreBtn = driver.findElement(By.xpath(nameAfterMoreBtnStr));
        String nameAfterMoreBtnTxt = nameAfterMoreBtn.getText();
        Assert.assertEquals("Not Match", nameAfterMoreBtnTxt, nameOfProductStr);

        WebElement colorLink = driver.findElement(By.xpath("//a[@name='Pink']"));
        colorLink.click();

        String URL = driver.getCurrentUrl();
        System.out.println(URL);
        Assert.assertTrue("Not match", URL.toLowerCase().contains("pink"));
    }

    @Test
    public void test3() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");

        String HeadPathLink = "//div[@class='block_content']//li[@class='last']";

        WebElement womenLink = driver.findElement(By.xpath("//a[@title='Women']"));
        womenLink.click();

        WebElement growOpen = driver.findElement(By.xpath(HeadPathLink + "//span[@class='grower CLOSE']"));
        growOpen.click();

        WebElement SumDressLink = driver.findElement(By.xpath(HeadPathLink + "//span/following-sibling::ul/li[@class='last']/a"));
        SumDressLink.click();

        Actions actions = new Actions(driver);
        WebElement leftMouse = driver.findElement(By.xpath("//a[@style='left: 0%;']"));
        WebElement rightMouse = driver.findElement(By.xpath("//a[@style='left: 100%;']"));
        actions.moveToElement(leftMouse).clickAndHold().perform();
        actions.moveToElement(leftMouse, 62, 0).release().perform();
        actions.moveToElement(rightMouse).clickAndHold().perform();
        actions.moveToElement(rightMouse, -60, 0).release().perform();


    }
}


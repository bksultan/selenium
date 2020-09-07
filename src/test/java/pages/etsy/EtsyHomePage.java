package pages.etsy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class EtsyHomePage {
    private static WebDriver driver;

    public EtsyHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='global-enhancements-search-query']")
    public WebElement searchBar;

    @FindBy(xpath = "//a[@href='https://www.etsy.com/search?q=antique+jewelry&explicit=1&max_processing_days=1&instant_download=false&locationQuery=6252001']")
    public WebElement oneBusinessDay;

    @FindBy(xpath = "//input[@id='search-filter-min-price-input']")
    public WebElement priceSearchFrom;

    @FindBy(xpath = "//input[@id='search-filter-max-price-input']")
    public WebElement priceSearchTo;

    @FindBy(xpath = "//a[@href='https://www.etsy.com/search?q=antique+jewelry&explicit=1&max_processing_days=1&instant_download=false&locationQuery=6252001&attr_357=71']")
    public WebElement material;

    @FindBy(xpath = "//a[@href='https://www.etsy.com/search?q=antique+jewelry&explicit=1&max_processing_days=1&instant_download=false&attr_357=71']/span")
    public WebElement shopLocation;

    @FindBy(id = "ship_to_select")
    public WebElement dropDown;

    public static void verifyTitle(String expectedTitle) {
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }
}


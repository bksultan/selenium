package day14.screenshotAmazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {
    private static WebDriver driver;

    public homePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchField;

    @FindBy(css = "#nav-search-submit-text")
    public WebElement searchButton;


}

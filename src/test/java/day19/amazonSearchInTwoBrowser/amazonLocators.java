package day19.amazonSearchInTwoBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class amazonLocators {
    public amazonLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public static amazonLocators getAmazonResultPage(WebDriver driver){
        amazonLocators amazonLocators = new amazonLocators(driver);
        return amazonLocators;
    }

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    public WebElement searchField;

    @FindBy(xpath = "//span[@id='nav-search-submit-text']")
    public WebElement submit;
}

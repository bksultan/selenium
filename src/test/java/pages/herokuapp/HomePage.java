package pages.herokuapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//a[@href='/abtest']")
    public WebElement abTestLink;

    @FindBy (xpath = "//h3")
    public WebElement abTestHeaderText;
}

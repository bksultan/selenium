package pages.herokuapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ABTestPage {
    public ABTestPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy (tagName = "h3")
    public WebElement abTestHeaderText;

    @FindBy (tagName = "p")
    public WebElement abTestParagraph;
}

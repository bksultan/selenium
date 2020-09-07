package day16.alerts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class alertHomePage {
    private static WebDriver driver;

    public alertHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@onclick='jsAlert()']")
    public WebElement jsAlert;

    @FindBy(xpath = "//button[@onclick='jsConfirm()']")
    public WebElement jsAlert1;

    @FindBy(xpath = "//button[@onclick='jsPrompt()']")
    public WebElement jsAlert2;

    @FindBy(id = "result")
    public WebElement jsConfirmResult;
}

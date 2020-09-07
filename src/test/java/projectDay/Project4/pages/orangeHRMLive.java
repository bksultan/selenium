package projectDay.Project4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class orangeHRMLive {
    public orangeHRMLive(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='txtUsername']")
    public WebElement username;

    @FindBy(xpath = "//input[@id='txtPassword']")
    public WebElement password;

    @FindBy(xpath = "//input[@id='btnLogin']")
    public WebElement submitButton;

    @FindBy(xpath = "//a[@id='menu_admin_viewAdminModule']")
    public WebElement adminTab;

    @FindBy(xpath = "//input[@id='ohrmList_chkSelectAll']")
    public WebElement checkbox;

    @FindBy(xpath = "//input[@type='checkbox']")
    public List<WebElement> checkboxes;

    @FindBy(xpath = "//td[@class='left']/a")
    public List<WebElement> names;

    @FindBy(xpath = "//input[@id='btnAdd']")
    public WebElement addName;

    @FindBy(xpath = "//input[@id='systemUser_employeeName_empName']")
    public WebElement nameInput;

    @FindBy(xpath = "//input[@id='systemUser_userName']")
    public WebElement userNameInput;

    @FindBy(xpath = "//a[@class='DESC']")
    public WebElement nameListSort;
}

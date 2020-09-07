package day16.sweetAlert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class sweetAlertHomePage {
    private static WebDriver driver;

    public sweetAlertHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(@onclick,'Oops, something went wrong!')]")
    public WebElement leftPreviewBtn;

    @FindBy(xpath = "//button[contains(@onclick,'swal')]")
    public WebElement rightPreviewBtn;
}

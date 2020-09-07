package day17.amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OpenEmrHomePage {
        private static WebDriver driver;

        public OpenEmrHomePage(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

        @FindBy(id = "twotabsearchtextbox")
        public WebElement searchField;

        @FindBy(xpath = "//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-4']")
        public List<WebElement> productNames;

        @FindBy(xpath = "//a[@class='a-size-base a-link-normal a-text-normal']/span[@class='a-price']/span[@class='a-offscreen']")
        public List<WebElement> productPrices;
    }


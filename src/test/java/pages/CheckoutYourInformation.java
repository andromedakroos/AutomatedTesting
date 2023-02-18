package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutYourInformation extends BasePage {
    @FindBy(id = "continue")
    public WebElement continueButton;
    @FindBy(id = "first-name")
    public WebElement firstNameInput;
    @FindBy(id = "last-name")
    public WebElement lastNameInput;
    @FindBy(id = "postal-code")
    public WebElement postalCodeInput;

    public CheckoutYourInformation(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return null;
    }

    public WebElement getPageIdentifierByElement() {
        return continueButton;
    }

}

package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutYourInformationPage extends BasePage {

    @FindBy(id = "continue")
    public WebElement continueButton;
    @FindBy(id = "first-name")
    public WebElement firstNameInput;
    @FindBy(id = "last-name")
    public WebElement lastNameInput;
    @FindBy(id = "postal-code")
    public WebElement postalCodeInput;

    public CheckoutYourInformationPage(WebDriver driver) {
        super(driver);
        logger.info("Using the CheckoutYourInformationPage class in which the PageFactory pattern is implemented");
    }

    @Override
    protected By getPageIdentifier() {
        return null;
    }

    public WebElement getPageIdentifierByElement() {
        return continueButton;
    }

}
package pages.SauceDemo;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutYourInformation extends BasePage {
    private final By continueButtonLocator = By.id("continue");
    private final By firstNameInputLocator = By.id("first-name");
    private final By lastNameInputLocator = By.id("last-name");
    private final By postalCodeInputLocator = By.id("postal-code");



    public CheckoutYourInformation(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return continueButtonLocator;
    }

    public WebElement getContinueButtonLocator() {
        return driver.findElement(continueButtonLocator);
    }

    public WebElement getFirstNameLocator() {
        return driver.findElement(firstNameInputLocator);
    }

    public WebElement getLastNameLocator() {
        return driver.findElement(lastNameInputLocator);
    }
    public WebElement getZipCodeLocator() {
        return driver.findElement(postalCodeInputLocator);
    }
}

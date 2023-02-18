package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import models.User;
import org.openqa.selenium.WebDriver;
import pages.CheckoutOverview;
import pages.CheckoutYourInformation;
import pages.FinishPage;


public class CheckoutStep extends BaseStep {
    private CheckoutYourInformation checkoutYourInformation;
    private CheckoutOverview checkoutOverview;
    private FinishPage finishPage;
    public CheckoutStep(WebDriver driver) {
        super(driver);
        checkoutYourInformation = new CheckoutYourInformation(driver);
        checkoutOverview = new CheckoutOverview(driver);
        finishPage = new FinishPage(driver);
    }
    public void checkoutYourInformation(String firstName, String lastName, String zipCode){
        checkoutYourInformation.firstNameInput.sendKeys(firstName);
        checkoutYourInformation.lastNameInput.sendKeys(lastName);
        checkoutYourInformation.postalCodeInput.sendKeys(zipCode);
        checkoutYourInformation.continueButton.click();
        checkoutOverview.isPageOpened();
    }
    public void checkoutOverview() {
        checkoutOverview.getFinishButtonLocator().click();
        finishPage.isFinishPageOpened();
    }
    @Step
    public FinishPage checkout(String name, String lastname, String zipcode) {
        checkoutYourInformation(name, lastname, zipcode);
        checkoutOverview();
        return finishPage;
    }
}

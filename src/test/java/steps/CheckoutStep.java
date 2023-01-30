package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.CheckoutOverviewPage;
import pages.CheckoutYourInformationPage;
import pages.FinishPage;


public class CheckoutStep extends BaseStep {
    private CheckoutYourInformationPage checkoutYourInformationPage;
    private CheckoutOverviewPage checkoutOverviewPage;
    private FinishPage finishPage;

    public CheckoutStep(WebDriver driver) {
        super(driver);
        checkoutYourInformationPage = new CheckoutYourInformationPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        finishPage = new FinishPage(driver);
    }

    public void checkoutYourInformation(String firstName, String lastName, String zipCode) {
        checkoutYourInformationPage.firstNameInput.sendKeys(firstName);
        checkoutYourInformationPage.lastNameInput.sendKeys(lastName);
        checkoutYourInformationPage.postalCodeInput.sendKeys(zipCode);
        checkoutYourInformationPage.continueButton.click();
        checkoutOverviewPage.isPageOpened();
    }

    public void checkoutOverview() {
        checkoutOverviewPage.getFinishButtonLocator().click();
        finishPage.isFinishPageOpened();
    }

    @Step
    public FinishPage checkout(User user) {
        logger.info("In step CheckoutStep User object is using, which contains fields: " + user);
        checkoutYourInformation(user.getName(), user.getLastName(), user.getZipCode());
        checkoutOverview();
        return finishPage;
    }
}

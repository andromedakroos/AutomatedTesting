package steps.SauceDemoSteps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.SauceDemo.*;

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
    public void checkoutOverview(){
        checkoutOverview.getFinishButtonLocator().click();
        finishPage.isFinishPageOpened();
    }
    @Step
    public FinishPage checkout(String firstName, String lastName, String zipCode){
        checkoutYourInformation(firstName,lastName,zipCode);
        checkoutOverview();
        return finishPage;
    }
}

package steps.SauceDemoSteps;

import baseEntities.BaseStep;
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
        checkoutYourInformation.getFirstNameLocator().sendKeys(firstName);
        checkoutYourInformation.getLastNameLocator().sendKeys(lastName);
        checkoutYourInformation.getZipCodeLocator().sendKeys(zipCode);
        checkoutYourInformation.getContinueButtonLocator().click();
        checkoutOverview.isPageOpened();
    }
    public void checkoutOverview(){
        checkoutOverview.getFinishButtonLocator().click();
        finishPage.isPageOpened();
        finishPage.getFinishLogoLocator().isDisplayed();
    }
    public FinishPage checkout(String firstName, String lastName, String zipCode){
        checkoutYourInformation(firstName,lastName,zipCode);
        checkoutOverview();
        return finishPage;
    }
}

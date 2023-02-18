package steps;


import io.qameta.allure.Step;
import models.User;
import org.openqa.selenium.WebDriver;
import pages.CheckoutOverview;
import pages.CheckoutYourInformation;
import pages.FinishPage;


public class CheckoutStep{
    private CheckoutYourInformation checkoutYourInformation;
    private CheckoutOverview checkoutOverview;
    private FinishPage finishPage;
    public CheckoutStep() {
        checkoutYourInformation = new CheckoutYourInformation();
        checkoutOverview = new CheckoutOverview();
        finishPage = new FinishPage();
    }
    public void checkoutYourInformation(String firstName, String lastName, String zipCode){
        checkoutYourInformation.getFirstNameInput().sendKeys(firstName);
        checkoutYourInformation.getLastNameInput().sendKeys(lastName);
        checkoutYourInformation.getPostalCodeInput().sendKeys(zipCode);
        checkoutYourInformation.getContinueButton().click();
    }
    public void checkoutOverview() {
        checkoutOverview.getFinishButtonLocator().click();
        finishPage.isFinishPageOpened();
    }
    @Step
    public FinishPage checkout(User user) {
        checkoutYourInformation(user.getName(),user.getLastName(),user.getZipCode());
        checkoutOverview();
        return finishPage;
    }
}
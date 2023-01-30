package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.CheckoutYourInformationPage;
import pages.InventoryPage;

public class AddToCartStep extends BaseStep {
    private CheckoutStep checkoutStep;
    private InventoryPage inventoryPage;
    private CartPage cartPage;
    private CheckoutYourInformationPage checkoutYourInformationPage;
    public AddToCartStep(WebDriver driver) {
        super(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutYourInformationPage = new CheckoutYourInformationPage(driver);
        checkoutStep = new CheckoutStep(driver);
    }
    private void goToCheckout(){
        cartPage.getCheckoutButtonLocator().click();
        checkoutYourInformationPage.getPageIdentifierByElement().isDisplayed();
    }
    @Step
    public CheckoutStep addAndGoToCheckout(){
        inventoryPage.getAddToCartButtonLocator().click();
        inventoryPage.getCartButtonLocator().click();
        cartPage.isPageOpened();
        goToCheckout();
        return checkoutStep;
    }
}

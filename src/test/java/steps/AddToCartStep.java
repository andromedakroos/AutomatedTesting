package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.CheckoutYourInformation;
import pages.InventoryPage;

public class AddToCartStep{
    private CheckoutStep checkoutStep;
    private InventoryPage inventoryPage;
    private CartPage cartPage;
    private CheckoutYourInformation checkoutYourInformation;
    public AddToCartStep() {
        inventoryPage = new InventoryPage();
        cartPage = new CartPage();
        checkoutYourInformation = new CheckoutYourInformation();
        checkoutStep = new CheckoutStep();
    }
    private void goToCheckout(){
        cartPage.getCheckoutButtonLocator().click();
    }
    @Step
    public CheckoutStep addAndGoToCheckout(){
        inventoryPage.getAddToCartButtonLocator().click();
        inventoryPage.getCartButtonLocator().click();
        goToCheckout();
        return checkoutStep;
    }
}
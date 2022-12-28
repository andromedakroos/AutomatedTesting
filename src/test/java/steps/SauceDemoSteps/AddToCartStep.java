package steps.SauceDemoSteps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.SauceDemo.CartPage;
import pages.SauceDemo.CheckoutYourInformation;
import pages.SauceDemo.InventoryPage;
import pages.SauceDemo.SauceDemoLoginPage;

public class AddToCartStep extends BaseStep {
    private InventoryPage inventoryPage;
    private CartPage cartPage;
    private CheckoutYourInformation checkoutYourInformation;
    public AddToCartStep(WebDriver driver) {
        super(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutYourInformation = new CheckoutYourInformation(driver);
    }
    public void addAndGoToCheckout(){
        inventoryPage.getAddToCartButtonLocator().click();
        inventoryPage.getCartButtonLocator().click();
        cartPage.isPageOpened();
        goToCheckout();
    }

    private void goToCheckout(){
        cartPage.getCheckoutButtonLocator().click();
        checkoutYourInformation.isPageOpened();
    }
}

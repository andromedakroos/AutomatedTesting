package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.CheckoutYourInformation;
import pages.InventoryPage;

public class AddToCartStep extends BaseStep {
    private CheckoutStep checkoutStep;
    private InventoryPage inventoryPage;
    private CartPage cartPage;
    private CheckoutYourInformation checkoutYourInformation;
    public AddToCartStep(WebDriver driver) {
        super(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutYourInformation = new CheckoutYourInformation(driver);
        checkoutStep = new CheckoutStep(driver);
    }
    public CheckoutStep goToCheckout(){
        cartPage.getCheckoutButtonLocator().click();
        return checkoutStep;
    }
    @Step
    public void addItemToTheCart(){
        inventoryPage.getAddToCartButtonLocator().click();
        inventoryPage.getCartButtonLocator().click();
        cartPage.isPageOpened();
    }
}

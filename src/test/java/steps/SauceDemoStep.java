package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;
import pages.SauceDemo.*;

public class SauceDemoStep extends BaseStep {
    private SauceDemoLoginPage sauceDemoLoginPage;
    private InventoryPage inventoryPage;
    private CartPage cartPage;
    private CheckoutStepOnePage checkoutStepOnePage;
    private CheckoutStepTwoPage checkoutStepTwoPage;
    private FinishPage finishPage;

    public SauceDemoStep(WebDriver driver) {
        super(driver);
        sauceDemoLoginPage = new SauceDemoLoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutStepOnePage = new CheckoutStepOnePage(driver);
        checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        finishPage = new FinishPage(driver);
    }

    public void login(String username, String password){
        sauceDemoLoginPage.getUsernameInput().sendKeys(username);
        sauceDemoLoginPage.getPasswordInput().sendKeys(password);
        sauceDemoLoginPage.getLogInButton().click();
        inventoryPage.isPageOpened();
    }

    public void addAndGoToCart(){
        inventoryPage.getAddToCartButtonLocator().click();
        inventoryPage.getCartButtonLocator().click();
        cartPage.isPageOpened();
    }

    public void goToCheckout(){
        cartPage.getCheckoutButtonLocator().click();
        checkoutStepOnePage.isPageOpened();
    }

    public void firstStepOfCheckout(String firstName, String lastName, String zipCode){
        checkoutStepOnePage.getFirstNameLocator().sendKeys(firstName);
        checkoutStepOnePage.getLastNameLocator().sendKeys(lastName);
        checkoutStepOnePage.getZipCodeLocator().sendKeys(zipCode);
        checkoutStepOnePage.getContinueButtonLocator().click();
        checkoutStepTwoPage.isPageOpened();

    }
    public void secondStepOfCheckout(){
        checkoutStepTwoPage.getFinishButtonLocator().click();
        finishPage.isPageOpened();
    }

    public void checkoutConfirmation(){
        Assert.assertTrue(finishPage.getFinishLogoLocator().isDisplayed());
    }

    public FinishPage checkoutCorrectly(String email, String password, String firstName, String lastName, String zipCode){
        login(email,password);
        addAndGoToCart();
        goToCheckout();
        firstStepOfCheckout(firstName,lastName,zipCode);
        secondStepOfCheckout();
        checkoutConfirmation();
        return finishPage;
    }
}

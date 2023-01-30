package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import models.User;
import org.openqa.selenium.WebDriver;
import pages.InventoryPage;
import pages.LoginPage;

public class LoginStep extends BaseStep {
    private LoginPage sauceDemoLoginPage;
    public InventoryPage inventoryPage;
    private AddToCartStep addToCartStep;

    public LoginStep(WebDriver driver) {
        super(driver);
        sauceDemoLoginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        addToCartStep = new AddToCartStep(driver);
    }
    @Step
    public AddToCartStep login(User user){
        sauceDemoLoginPage.getUsernameInput().sendKeys(user.getUsername());
        sauceDemoLoginPage.getPasswordInput().sendKeys(user.getPassword());
        sauceDemoLoginPage.getLogInButton().click();
        inventoryPage.isPageOpened();
        return addToCartStep;
    }
}
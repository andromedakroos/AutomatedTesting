package steps.SauceDemoSteps;

import baseEntities.BaseStep;
import baseEntities.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.SauceDemo.*;

public class LoginStep extends BaseStep {
    private SauceDemoLoginPage sauceDemoLoginPage;
    public InventoryPage inventoryPage;
    private AddToCartStep addToCartStep;

    public LoginStep(WebDriver driver) {
        super(driver);
        sauceDemoLoginPage = new SauceDemoLoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        addToCartStep = new AddToCartStep(driver);
    }
    @Step
    public AddToCartStep login(String username, String password){
        sauceDemoLoginPage.getUsernameInput().sendKeys(username);
        sauceDemoLoginPage.getPasswordInput().sendKeys(password);
        sauceDemoLoginPage.getLogInButton().click();
        inventoryPage.isPageOpened();
        return addToCartStep;
    }
}

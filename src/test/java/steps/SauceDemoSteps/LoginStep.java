package steps.SauceDemoSteps;

import baseEntities.BaseStep;
import baseEntities.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.SauceDemo.*;

public class LoginStep extends BaseStep {
    private SauceDemoLoginPage sauceDemoLoginPage;
    private InventoryPage inventoryPage;

    public LoginStep(WebDriver driver) {
        super(driver);
        sauceDemoLoginPage = new SauceDemoLoginPage(driver);
        inventoryPage = new InventoryPage(driver);
    }
    @Step
    public InventoryPage login(String username, String password){
        sauceDemoLoginPage.getUsernameInput().sendKeys(username);
        sauceDemoLoginPage.getPasswordInput().sendKeys(password);
        sauceDemoLoginPage.getLogInButton().click();
        inventoryPage.isPageOpened();
        return inventoryPage;
    }
}

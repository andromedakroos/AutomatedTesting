package steps;


import io.qameta.allure.Step;
import models.User;
import org.openqa.selenium.WebDriver;
import pages.InventoryPage;
import pages.SauceDemoLoginPage;

public class LoginStep{
    private SauceDemoLoginPage sauceDemoLoginPage;
    public InventoryPage inventoryPage;
    private AddToCartStep addToCartStep;

    public LoginStep() {
        sauceDemoLoginPage = new SauceDemoLoginPage();
        inventoryPage = new InventoryPage();
        addToCartStep = new AddToCartStep();
    }
    @Step
    public AddToCartStep login(User user){
        sauceDemoLoginPage.getUsernameInput().sendKeys(user.getUsername());
        sauceDemoLoginPage.getPasswordInput().sendKeys(user.getPassword());
        sauceDemoLoginPage.getLogInButton().click();
        return addToCartStep;
    }
}
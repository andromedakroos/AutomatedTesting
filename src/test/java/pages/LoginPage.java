package pages;

import baseEntities.BasePage;
import elements.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    // Блок описания локаторов для эментов
    @FindBy(name = "error-text")
    public WebElement errorText;
    @FindBy(id = "name")
    public WebElement emailInput;
    @FindBy(id = "password")
    public WebElement passwordInput;
    @FindBy(id = "button_primary")
    public WebElement logInButton;

    // Блок иницализации страницы
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Блок атомарных методов
//    public WebElement getEmailInput() { return new UIElement(driver, emailInputLocator);}
//    public WebElement getPassword() { return new UIElement(driver, passwordInputLocator);}
//    public UIElement getLogInButton() { return new UIElement(driver, logInButtonLocator);}
//    public WebElement getErrorTextElement() { return new UIElement(driver, errorTextLocator); }
}

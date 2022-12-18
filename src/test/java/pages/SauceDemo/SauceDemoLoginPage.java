package pages.SauceDemo;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SauceDemoLoginPage extends BasePage {
    private final By usernameLocator = By.id("user-name");
    private final By passwordLocator = By.id("password");
    private final By logInButtonLocator = By.id("login-button");
    private final static String pagePath = "https://www.saucedemo.com/";

    public SauceDemoLoginPage(WebDriver driver) {
        super(driver);
        openPageByUrl();
    }

    @Override
    protected By getPageIdentifier() {
        return logInButtonLocator;
    }


    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public WebElement getUsernameInput() {
        return driver.findElement(usernameLocator);
    }
    public WebElement getPasswordInput() {
        return driver.findElement(passwordLocator);
    }
    public WebElement getLogInButton() {
        return driver.findElement(logInButtonLocator);
    }
}

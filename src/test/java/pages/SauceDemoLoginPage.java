package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SauceDemoLoginPage{
    private  By usernameLocator = By.id("user-name");
    private  By passwordLocator = By.id("password");
    private  By logInButtonLocator = By.id("login-button");
//    private final static String pagePath = "https://www.saucedemo.com/";

//    public SauceDemoLoginPage() {
//        openPageByUrl();
//    }
//
//    public void openPageByUrl() {
//        open(pagePath);
//    }

    public SelenideElement getUsernameInput() {
        return $(usernameLocator).shouldBe(visible);
    }
    public SelenideElement getPasswordInput() {
        return $(passwordLocator).shouldBe(visible);
    }
    public SelenideElement getLogInButton() {
        return $(logInButtonLocator).shouldBe(visible);
    }
}
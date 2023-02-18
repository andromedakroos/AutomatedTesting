package pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CartPage {
    private final By checkoutButtonLocator = By.id("checkout");
    public SelenideElement getCheckoutButtonLocator() {
        return $(checkoutButtonLocator).shouldBe(visible);
    }
}

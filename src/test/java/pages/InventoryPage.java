package pages;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class InventoryPage{

    private final By addToCartButtonLocator = By.id("add-to-cart-sauce-labs-backpack");
    private final By cartButtonLocator = By.className("shopping_cart_link");

    public SelenideElement getAddToCartButtonLocator() {
        return $(addToCartButtonLocator).shouldBe(visible);
    }
    public SelenideElement getCartButtonLocator() {
        return $(cartButtonLocator).shouldBe(visible);
    }
}
package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage extends BasePage {

    private final By addToCartButtonLocator = By.id("add-to-cart-sauce-labs-backpack");
    private final By cartButtonLocator = By.className("shopping_cart_link");


    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return addToCartButtonLocator;
    }

    public WebElement getAddToCartButtonLocator() {
        return driver.findElement(addToCartButtonLocator);
    }
    public WebElement getCartButtonLocator() {
        return driver.findElement(cartButtonLocator);
    }
}

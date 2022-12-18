package pages.SauceDemo;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutStepTwoPage extends BasePage {
    private final By finishButtonLocator = By.id("finish");

    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return finishButtonLocator;
    }

    public WebElement getFinishButtonLocator(){
        return driver.findElement(finishButtonLocator);
    }
}

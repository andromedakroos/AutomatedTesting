package pages.SauceDemo;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FinishPage extends BasePage {
    private final By finishLogoLocator = By.className("pony_express");


    public FinishPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return finishLogoLocator;
    }

    public WebElement getFinishLogoLocator(){
        return driver.findElement(finishLogoLocator);
    }
}

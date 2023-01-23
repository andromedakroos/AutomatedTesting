package pages.SauceDemo;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FinishPage extends BasePage {
//    private final By finishLogoLocator = By.className("pony_express");
    @FindBy(className = "pony_express")
    public WebElement finishLogo;

    public FinishPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return null;
    }

    public boolean isFinishPageOpened(){
        return finishLogo.isDisplayed();
    }


}

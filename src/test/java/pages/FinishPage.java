package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

public class FinishPage{

    private By finishButtonLocator = By.id("back-to-products");

    public boolean isFinishPageOpened() {
        return $(finishButtonLocator).isDisplayed();
    }

}
package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FinishPage extends BasePage {
    @FindBy(id = "back-to-products")
    public WebElement finishButton;

    public FinishPage(WebDriver driver) {
        super(driver);
        logger.info("Using the FinishPage class in which the PageFactory pattern is implemented");
    }

    @Override
    protected By getPageIdentifier() {
        return null;
    }

    public boolean isFinishPageOpened(){
        return finishButton.isDisplayed();
    }


}

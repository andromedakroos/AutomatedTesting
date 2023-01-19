package pages.project;

import baseEntities.BasePage;
import elements.DropDown;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddTestCasePage extends BasePage {
    private DropDown dropDown;
    public AddTestCasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return null;
    }

    public DropDown getDropDown(){
        dropDown = new DropDown(driver, "text");
        return dropDown;
    }
}

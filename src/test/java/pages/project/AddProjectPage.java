package pages.project;

import baseEntities.BasePage;
import elements.Checkbox;
import elements.RadioButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddProjectPage extends BasePage {
    private final static String pagePath = "index.php?/admin/projects/add";

    private final By addProjectButtonLocator = By.id("accept");
    private final By nameInputLocator = By.id("name");

    public AddProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return null;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public WebElement getAddProjectButton() {
        return driver.findElement(addProjectButtonLocator);
    }

    public WebElement getNameInput() {
        return driver.findElement(nameInputLocator);
    }

    public RadioButton getType() {
        return new RadioButton(driver, "suite_mode");
    }
    public Checkbox getCheckbox(){
        return new Checkbox(driver, "show_announcement");
    }

}

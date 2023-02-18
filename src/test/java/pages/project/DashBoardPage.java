package pages.project;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage extends BasePage {
    private final static String pagePath = "index.php?/dashboard";
    private final By headerTittleLabelLocator = By.xpath("//div[contains(text(), 'All Projects')]");

    public DashBoardPage(WebDriver driver) {
        super(driver);
        openPageByUrl();
    }
    @Override
    protected By getPageIdentifier() {
        return headerTittleLabelLocator;
    }
    public void openPageByUrl(){
        super.openPageByUrl(pagePath);
    }

    public String getTitle(){
        return waitsService.waitForVisibilityBy(headerTittleLabelLocator).getText();
    }
}

package baseEntities;

import configuration.ReadProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import services.WaitsService;

public abstract class BasePage {
    protected WaitsService waitsService;
    protected WebDriver driver;
    protected Logger logger;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        waitsService = new WaitsService(driver);
        logger = LogManager.getLogger();
        PageFactory.initElements(driver,this);
    }

    protected abstract By getPageIdentifier();

    public boolean isPageOpened(){
        return waitsService.waitForVisibilityBy(getPageIdentifier()).isDisplayed();
    }

    public void openPageByUrl(String pagePath){
        driver.get(pagePath);
    }
}

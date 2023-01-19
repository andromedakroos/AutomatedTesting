package baseEntities;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v106.page.Page;
import org.openqa.selenium.support.PageFactory;
import services.WaitsService;

public abstract class BasePage {
    protected WaitsService waitsService;
    protected WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        waitsService = new WaitsService(driver);
        PageFactory.initElements(driver,this);
    }

    public void openPageByUrl(String pagePath){
        driver.get(ReadProperties.getUrl() + pagePath);
    }
}

package baseEntities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v106.page.Page;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    protected abstract By getPageIdentifier();

    public boolean isPageOpened(){
        return driver.findElement(getPageIdentifier()).isDisplayed();
    }

//    public void openPageByUrl(String pagePath){
//        driver.get(ReadProperties.getUrl() + pagePath);
//    }
    public void openPageByUrl(String pagePath){
        driver.get(pagePath);
    }
}

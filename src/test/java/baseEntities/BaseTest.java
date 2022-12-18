package baseEntities;

import configuration.ReadProperties;
import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.SauceDemoStep;
import steps.UserStep;

public class BaseTest {
    protected WebDriver driver;
    protected UserStep userStep;
    protected SauceDemoStep sauceDemoStep;

    @BeforeMethod
    public void setUp(){
        driver = new BrowserFactory().getDriver();
//        driver.get(ReadProperties.getUrl());

        userStep = new UserStep(driver);
        sauceDemoStep = new SauceDemoStep(driver);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

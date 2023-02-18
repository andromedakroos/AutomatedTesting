package baseEntities;

import configuration.ReadProperties;
import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import services.WaitsService;


public class BaseTest {
    protected WebDriver driver;
    protected WaitsService waitsService;

    @BeforeMethod
    public void setUp(ITestContext iTestContext){
        driver = new BrowserFactory().getDriver();
        driver.get(ReadProperties.getUrl());

        iTestContext.setAttribute("driver", driver);

        waitsService = new WaitsService(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

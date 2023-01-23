package baseEntities;

import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import steps.SauceDemoSteps.AddToCartStep;
import steps.SauceDemoSteps.CheckoutStep;
import steps.SauceDemoSteps.LoginStep;
import utils.InvokedListener;

@Listeners(InvokedListener.class)
public class BaseTest {
    protected WebDriver driver;
    protected LoginStep loginStep;
    protected AddToCartStep addToCartStep;
    protected CheckoutStep checkoutStep;

    @BeforeMethod
    public void setUp(ITestContext iTestContext){
        driver = new BrowserFactory().getDriver();
        loginStep = new LoginStep(driver);
        addToCartStep = new AddToCartStep(driver);
        checkoutStep = new CheckoutStep(driver);
        iTestContext.setAttribute("driver", driver);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

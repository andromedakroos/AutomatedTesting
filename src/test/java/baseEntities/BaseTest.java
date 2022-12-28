package baseEntities;

import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.SauceDemoSteps.AddToCartStep;
import steps.SauceDemoSteps.CheckoutStep;
import steps.SauceDemoSteps.LoginStep;
import steps.UserStep;

public class BaseTest {
    protected WebDriver driver;
    protected UserStep userStep;
    protected LoginStep loginStep;
    protected AddToCartStep addToCartStep;
    protected CheckoutStep checkoutStep;

    @BeforeMethod
    public void setUp(){
        driver = new BrowserFactory().getDriver();
        userStep = new UserStep(driver);
        loginStep = new LoginStep(driver);
        addToCartStep = new AddToCartStep(driver);
        checkoutStep = new CheckoutStep(driver);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

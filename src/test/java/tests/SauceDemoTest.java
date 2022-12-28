package tests;

import baseEntities.BaseTest;
import org.testng.annotations.Test;

public class SauceDemoTest extends BaseTest {
    @Test
    public void sauceDemoE2ETest() throws InterruptedException {
        loginStep.login("standard_user","secret_sauce");
        addToCartStep.addAndGoToCheckout();
        checkoutStep.checkout("Andrew",
                "Moroz", "30-605").isPageOpened();
    }
}

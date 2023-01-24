package tests;

import baseEntities.BaseTest;
import io.qameta.allure.Attachment;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceDemoTest extends BaseTest {
    @Test(description = "Sauce demo end 2 end test")
//    public void sauceDemoE2ETest(){
//        loginStep.login("standard_user","secret_sauce");
//        addToCartStep.addAndGoToCheckout();
//        Assert.assertTrue(checkoutStep.checkout("Andrew",
//                "Moroz", "30-605").isFinishPageOpened());
//    }
    public void sauceDemoE2ETest(){
        loginStep.login("standard_user","secret_sauce")
                .;
        addToCartStep.addAndGoToCheckout();
        Assert.assertTrue(checkoutStep.checkout("Andrew",
                "Moroz", "30-605").isFinishPageOpened());
    }
    @Test(description = "Sauce demo failed test")
    @Attachment(value = "screenshot", type = "image/png")
    public void sauceDemoFailedLoginTest(){
        loginStep.login("1233", "1222");
    }

}

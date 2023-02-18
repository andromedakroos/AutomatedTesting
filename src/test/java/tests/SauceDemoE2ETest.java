
package tests;

import baseEntities.BaseTest;
import io.qameta.allure.Attachment;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceDemoE2ETest extends BaseTest {
    @Test(description = "Sauce demo end 2 end test")
    public void sauceDemoE2ETest(){
        Assert.assertTrue(loginStep.login(user)
                .addAndGoToCheckout()
                .checkout(user).isFinishPageOpened());
    }
}
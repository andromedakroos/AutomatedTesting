package tests;

import baseEntities.BaseTest;
import org.testng.annotations.Test;

public class SauceDemoTest extends BaseTest {
    @Test
    public void sauceDemoE2ETest() throws InterruptedException {
        sauceDemoStep.checkoutCorrectly("standard_user", "secret_sauce", "Andrew", "Moroz", "30-605").isPageOpened();
        Thread.sleep(2000);
    }
}

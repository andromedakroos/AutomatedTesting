package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FramesTest extends BaseTest {
    @Test
    public void frameTest(){
        driver.get("http://the-internet.herokuapp.com/frames");
        waitsService.waitForVisibilityBy(By.linkText("iFrame")).click();
        driver.switchTo().frame("mce_0_ifr");
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText().trim(), "Your content goes here.");
    }
}

package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicControlsTest extends BaseTest {
    @Test
    public void dynamicControlsTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement checkBox = waitsService.waitForVisibilityBy(By.id("checkbox"));
        Actions actions = new Actions(driver);
        waitsService.waitForVisibilityBy(By.xpath("//*[text() = 'Remove']")).click();
        Assert.assertEquals(waitsService.waitForVisibilityBy(By.id("message")).getText(), "It's gone!");
        Assert.assertTrue(waitsService.waitForElementInvisible(checkBox));
        WebElement input = waitsService.waitForVisibilityBy(By.cssSelector("[type='text']"));
        Assert.assertFalse(input.isEnabled());
        waitsService.waitForVisibilityBy(By.xpath("//*[text() = 'Enable']")).click();
        Assert.assertEquals(waitsService.waitForVisibilityBy(By.id("message")).getText(), "It's enabled!");
        Assert.assertTrue(input.isEnabled());
    }
}

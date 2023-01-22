package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class DownloadFileTest extends BaseTest {
    @Test
    public void downloadFileTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        WebElement file = waitsService.waitForVisibilityBy(By.linkText("LambdaTest.txt"));
        file.click();
        String fileName = file.getText();
        Assert.assertTrue(waitsService.isFileExist(System.getProperty("user.dir") + File.separator+ fileName));
    }
}

package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadFileTest extends BaseTest {
    @Test
    public void uploadFileTest(){
        driver.get("http://the-internet.herokuapp.com/upload");
        WebElement fileUploadButton = waitsService.waitForVisibilityBy(By.id("file-upload"));
        String pathToFile = UploadFileTest.class.getClassLoader().getResource("smeshariki.webp").getPath().substring(1);
        fileUploadButton.sendKeys(pathToFile);
        waitsService.waitForVisibilityBy(By.id("file-submit")).submit();
        Assert.assertEquals(waitsService.waitForVisibilityBy(By.id("uploaded-files")).getText().trim(), "smeshariki.webp");
    }
}

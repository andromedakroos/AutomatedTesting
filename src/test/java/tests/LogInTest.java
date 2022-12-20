package tests;

import baseEntities.BaseTest;
import com.fasterxml.jackson.databind.ser.Serializers;
import configuration.ReadProperties;
import factory.BrowserFactory;
import org.bouncycastle.dvcs.DVCSRequestInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashBoardPage;
import pages.LoginPage;

public class LogInTest extends BaseTest {

//    @Test
    public void loginSuccessfulTest(){
        Assert.assertTrue(userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password()).isPageOpened());
    }
//    @Test
    public void loginIncorrectTest(){
        Assert.assertEquals(userStep.loginIncorrect(ReadProperties.username(), "123213")
                .getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again.");
    }

}

package tests;

import baseEntities.BaseTest;
import com.fasterxml.jackson.databind.ser.Serializers;
import configuration.ReadProperties;
import factory.BrowserFactory;
import io.qameta.allure.*;
import models.Project;
import org.bouncycastle.dvcs.DVCSRequestInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashBoardPage;
import pages.LoginPage;
import pages.project.AddProjectPage;
import steps.NavigationSteps;
import steps.UserStep;

public class  LogInTest extends BaseTest {

    @Test
    public void loginSuccessfulTest(){
        Assert.assertTrue(userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password()).isPageOpened());
    }
    @Test(description = "Description")
    @Issue("AutomatedTesting-12")
    @TmsLink("TC-001")
    @Description("Description1")
    @Link("https://onliner.by")
    @Link(name = "catalog", type = "mylink", url = "https://onliner.by")
    @Severity(SeverityLevel.BLOCKER)
    public void loginIncorrectTest(){
        Assert.assertEquals(userStep.loginIncorrect(ReadProperties.username(), "123213")
                .getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again.");
    }
    @Test
    public void addProjectTest() {
        Project project = new Project();
        project.setName("WP_01");
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        projectSteps.addProject(project);

        Assert.assertEquals(driver.findElement(By.className("page_title")).getText(),
                project.getName());
    }

    @Test
    public void radioButtonTest() {
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        AddProjectPage page = new NavigationSteps(driver).navigateToAddProjectPage();
        page.getType().selectByIndex(1);
        page.getType().selectByValue("3");
    }


}

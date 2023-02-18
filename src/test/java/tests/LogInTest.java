package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import io.qameta.allure.*;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.project.AddProjectPage;
import steps.project.NavigationSteps;

public class  LogInTest extends BaseTest {

    @Test
    public void loginSuccessfulTest(){
        User user = new User.Builder()
                .withEmail(ReadProperties.username())
                .withPassword(ReadProperties.password())
                .build();
        Assert.assertTrue(userStep.loginSuccessful(user).isPageOpened());
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
//    @Test
//    public void addProjectTest() {
//        Project project = new Project();
//        project.setName("WP_01");
//        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
//        projectSteps.addProject(project);
//
//        Assert.assertEquals(driver.findElement(By.className("page_title")).getText(),
//                project.getName());
//    }

    @Test
    public void radioButtonTest() {
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        AddProjectPage page = new NavigationSteps(driver).navigateToAddProjectPage();
        page.getType().selectByIndex(1);
        page.getType().selectByValue("3");
    }


}

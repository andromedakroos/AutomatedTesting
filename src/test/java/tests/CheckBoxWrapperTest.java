package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.annotations.Test;
import pages.project.AddProjectPage;
import steps.NavigationSteps;

import javax.swing.*;

public class CheckBoxWrapperTest extends BaseTest {
    @Test
    public void checkBoxWrapperTest(){
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        AddProjectPage page = new NavigationSteps(driver).navigateToAddProjectPage();
        page.getCheckbox().select();
        System.out.println(page.getCheckbox().isSelected());
        page.getCheckbox().deselect();
        System.out.println(page.getCheckbox().isSelected());
    }
}

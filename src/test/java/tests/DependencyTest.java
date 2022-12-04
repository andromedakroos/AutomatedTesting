package tests;

import calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyTest {
    Calculator calculator = new Calculator();
    @Test
    public void stepB(){
        Assert.assertEquals(calculator.sum(2,3),5, "Все плохо");
    }
    @Test(dependsOnMethods = "stepB" )
    public void stepA(){
        Assert.assertEquals(calculator.sum(2,3),5, "Все плохо");
    }
    @Test(dependsOnMethods = "stepA", alwaysRun = true)
    public void stepD(){
        Assert.assertEquals(calculator.sum(2,3),5, "Все плохо");
    }
    @Test(dependsOnMethods = {"stepD", "stepA"})
    public void stepC(){
        Assert.assertEquals(calculator.sum(2,3),5, "Все плохо");
    }
}

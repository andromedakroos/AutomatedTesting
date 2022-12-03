package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupTest {
    Calculator calculator = new Calculator();
    @Test(groups = "smoke")
    public void stepB(){
        Assert.assertEquals(calculator.sum(2,3),5, "Все плохо");
    }
    @Test(groups = "regression")
    public void stepA(){
        Assert.assertEquals(calculator.sum(2,3),5, "Все плохо");
    }
    @Test(groups = "regression")
    public void stepD(){
        Assert.assertEquals(calculator.sum(2,3),5, "Все плохо");
    }
    @Test(groups = {"regression", "smoke"})
    public void stepC(){
        Assert.assertEquals(calculator.sum(2,3),5, "Все плохо");
    }
}

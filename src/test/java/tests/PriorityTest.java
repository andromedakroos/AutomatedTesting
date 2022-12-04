package tests;

import calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PriorityTest {
    Calculator calculator = new Calculator();
    @Test
    public void stepB(){
        Assert.assertEquals(calculator.sum(2,3),5, "Все плохо");
    }
    @Test(priority = 1)
    public void stepA(){
        Assert.assertEquals(calculator.sum(2,3),5, "Все плохо");
    }
    @Test(priority = 3)
    public void stepD(){

        Assert.assertEquals(calculator.sum(2,3),5, "Все плохо");
    }
    @Test(priority = 2)
    public void stepC(){

        Assert.assertEquals(calculator.sum(2,3),5, "Все плохо");
    }
}

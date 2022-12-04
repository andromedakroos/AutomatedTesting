package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import calculator.Calculator;
import tests.data.StaticProvider;


public class DivisionTest {
    Calculator calculator = new Calculator();

    @Test(enabled = true, testName = "Тест деления целых чисел", description = "Простой тест деления целых чисел", timeOut = 1000, invocationCount = 3, threadPoolSize = 2, groups = "smoke")
    public void testIntegerDivision(){
        Assert.assertEquals(calculator.div(45, 15), 3, "Результат считается неправильно");
    }

    @Test(enabled = true, testName = "Тест деления дробных чисел", description = "Простой тест деления дробных чисел", timeOut = 1000, invocationCount = 3, threadPoolSize = 2, groups = "smoke")
    public void testDoubleDivision(){
        Assert.assertEquals(calculator.div(48.8, 12.2), 4.0, "Результат считается неправильно");
    }

    @Test(dataProvider = "dataForIntegerDivision", dataProviderClass = StaticProvider.class, threadPoolSize = 3, testName = "Тест деления целых чисел с помощью DataProvider", groups = "regression")
    public void testIntegerDivisionWithData(int a, int b, int expected){
        Assert.assertEquals(calculator.div(a,b), expected, "We've got a problem :(");
    }

    @Test(dataProvider = "dataForDoubleDivision", dataProviderClass = StaticProvider.class, threadPoolSize = 3, testName = "Тест деления дробных чисел с помощью DataProvider", groups = "regression")
    public void testDoubleDivisionWithData(double a, double b, double expected){
        Assert.assertEquals(calculator.div(a,b), expected, "We've got a problem :(");
    }

    @Test(expectedExceptions = ArithmeticException.class, groups = "smoke", testName = "Тест проверки деления целых на 0")
    public void testIntegerDivisionByZero(){
        Assert.assertEquals(calculator.div(10, 0),0, "Division by zero is not allowed");
    }

    @Test(expectedExceptions = ArithmeticException.class, groups = "smoke", testName = "Тест проверки деления целых на 0")
    public void testDoubleDivisionByZero(){
        Assert.assertEquals(calculator.div(10.0, 0.0),0.0, "Division by zero is not allowed");
    }
}

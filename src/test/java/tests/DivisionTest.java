package tests;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import calculator.Calculator;
import tests.data.StaticProvider;
import utils.Retry;


public class DivisionTest extends BaseTest {
    Calculator calculator = new Calculator();
    private int attempt = 1;

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

    @Test(priority = 1)
    public void testForNaN() {
        Assert.assertEquals(calculator.div(0.0, 0.0), Double.NaN);
    }
    @Test(dependsOnMethods = "testFortNegativeInfinity")
    public void testForPositiveInfinity() {
        Assert.assertEquals(calculator.div(10.0, 0.0), Double.POSITIVE_INFINITY);
    }
    @Test
    public void testFortNegativeInfinity() {
        Assert.assertEquals(calculator.div(-10.0, 0.0), Double.NEGATIVE_INFINITY);
    }

    @Test(retryAnalyzer = Retry.class)
    public void flakyTestDivInt() {
        if (attempt == 5) {
            Assert.assertEquals(calculator.div(32, 8), 4);
        } else {
            attempt++;
            System.out.println("Attempt is: " + attempt);
            throw new NullPointerException();
        }
    }

    @Parameters({"firstNum", "secondNum"})
    @Test
    public void divParametersTest(@Optional("10") String firstNumber,
                                  @Optional("2") String secondNumber) {
        System.out.println("" + firstNumber + " / " + secondNumber + " = " +
                Integer.parseInt(firstNumber) / Integer.parseInt(secondNumber));
    }

}


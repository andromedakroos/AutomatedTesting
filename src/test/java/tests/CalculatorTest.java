package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CalculatorTest extends  BaseTest{
    @Test
    public void testSum(){
        Assert.assertEquals(calculator.sum(2,3),5, "Все плохо");
    }
    @Test(enabled = false)
    public void testSum2(){
        Assert.assertEquals(calculator.sum(2,3),5, "Все плохо");
    }

    @Test(description = "Тест с описанием")
    public void testSum3(){
        Assert.assertEquals(calculator.sum(2,3),5, "Все плохо");
    }

    @Test(testName = "Тест с названием")
    public void testSum4(){
        Assert.assertEquals(calculator.sum(2,3),5, "Все плохо");
    }

    @Test(timeOut = 5000)
    public void testSum5() throws InterruptedException {
//        Assert.assertEquals(calculator.sum(2,3),5, "Все плохо");
        Thread.sleep(3000);
    }

    @Test(invocationCount = 8, invocationTimeOut = 1000, threadPoolSize = 4)
    public void testSum6() throws InterruptedException {
//        Thread.sleep(500);
        Assert.assertEquals(calculator.sum(2,3),5, "Все плохо");
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void exceptionTest(){
        List list = null;
        int size = list.size();
    }
//    @Test
//    public void testSum10(){
//        Assert.assertEquals(calculator.sum(2,3),10, "Все плохо");
//    }
}

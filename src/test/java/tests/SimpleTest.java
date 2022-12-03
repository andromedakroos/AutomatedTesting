package tests;

import org.testng.annotations.Test;

public class SimpleTest extends BaseTest {

    @Test
    public void test1(){
        System.out.println("My second test!");
    }

    @Test
    public void test2(){
        System.out.println("My 3 test!");
    }
}

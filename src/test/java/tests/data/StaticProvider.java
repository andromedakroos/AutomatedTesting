package tests.data;

import org.testng.annotations.DataProvider;

public class StaticProvider {
    @DataProvider(name = "dataForSum")
    public static Object[][] dataForSumTest(){
        return new Object[][]{
                { -2, -3, -5},
                { 0, 0, 0},
                { 2, 3, 5}
        };
    }

    @DataProvider(name = "dataForIntegerDivision")
    public static Object[][] dataForIntegerDivisionTest(){
        return new Object[][]{
                { 60, 5, 12},
                { 100, 2, 50},
                { 200, 100, 2}
        };
    }

    @DataProvider(name = "dataForDoubleDivision")
    public static Object[][] dataForDoubleDivisionTest(){
        return new Object[][]{
                { 22.2, 11.1, 2},
                { 41.0, 2, 20.5},
                { 295, 2, 147.5}
        };
    }
}

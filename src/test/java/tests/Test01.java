package tests;

import org.junit.*;

public class Test01 {
    @BeforeClass
    public static void beforeClass(){
        System.out.println("Before test class");
    }
    @Before
    public void beforeMyTest(){
        System.out.println("Before Test");
    }

    @Test
    public void myTest1(){
        System.out.println("test");
    }
    @Test
    public void myTest2(){
        System.out.println("test 2");
    }
    @After
    public void afterMyTest(){
        System.out.println("After Test");
    }
    @AfterClass
    public static void afterClass(){
        System.out.println("After test class");
    }
}

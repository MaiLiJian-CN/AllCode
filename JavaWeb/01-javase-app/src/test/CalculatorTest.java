package test;

import junit.Calculator;
import org.junit.After;
import org.junit.Before;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CalculatorTest {
    /**
     * 初始化方法，测试执行之前先执行该方法
     */
    @BeforeTest
    public void init(){
        System.out.println("init....");
    }
    @AfterTest
    public void after(){
        System.out.println("---");
    }

//    @Test
//    public void testAdd(){
//        System.out.println("执行测试");
//    }

    @Test
    public void testAdd2(){
        Calculator c=new Calculator();
        int result=c.add(1,2);
        System.out.println("0000000000");
        //断言
        Assert.assertEquals(result,3);
    }
}

package com.itheima;
import org.junit.Test;
import org.junit.Assert;

public class DemoTest{
         @Test
         public void sayTest(){
	Demo d=new Demo();
	String res=d.say();
	Assert.assertEquals("Hello",res);	
 }
}
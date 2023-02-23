package com.yichen;

import org.junit.Assert;
import org.junit.Test;

public class DemoTest {
    @Test
    public void testSay(){
        Demo d=new Demo();
        String ret= d.say("mlj");
        Assert.assertEquals("hello mlj",ret);
    }
}

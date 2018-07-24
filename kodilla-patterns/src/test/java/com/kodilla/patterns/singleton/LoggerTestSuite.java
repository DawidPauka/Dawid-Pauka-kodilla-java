package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {

    @Test
    public void getLastLogTest(){
        //Given
        String log = "1st log";
        String log2 = "2nd log";
        //When
        Logger.getInstance().log(log);
        Logger.getInstance().log(log2);
        //Then
        Assert.assertEquals(log2, Logger.getInstance().getLastLog());
    }
}
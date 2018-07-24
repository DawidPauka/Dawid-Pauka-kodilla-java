package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {
    @Test
    public void testCalculations() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);

        //When
        double addResult = calculator.add(25678, 854376);
        double subResult = calculator.sub(345, 5);
        double mulResult = calculator.mul(10, 123456);
        double divResult = calculator.div(1000, 10);

        //Then
        Assert.assertEquals(880054, addResult, 0.01);
        Assert.assertEquals(340, subResult, 0.01);
        Assert.assertEquals(1234560, mulResult, 0.01);
        Assert.assertEquals(100, divResult, 0.01);
    }
}
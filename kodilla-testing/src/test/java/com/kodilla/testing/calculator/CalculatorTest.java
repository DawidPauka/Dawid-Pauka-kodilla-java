package com.kodilla.testing.calculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
public void  test(){

        Calculator calculator = new Calculator(2,11);

        int result = calculator.substractBFromA();

        assertEquals(-9,result);


    }
}
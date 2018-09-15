package com.kodilla.testing.calculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
public void  test(){

        Calculator calculator = new Calculator(2,11);

        int result = calculator.substractBFromA();

        assertEquals(-9,result);

        System.out.println("result substraction  = " + result);

        Calculator calculator1 = new Calculator(45,50);

        int result1 = calculator1.addAToB  ();

        assertEquals(95,result1);

        System.out.println("result addition = " + result1);


    }
}
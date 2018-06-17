package com.kodilla.stream.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverageSeveralElements() {
        //GIVEN
        int[] intArray = {-987, -654, -321, 0, 100, 100, 123, 456, 789};
        double expectedAverage = -43.777_777_777_777;

        //WHEN
        double result = ArrayOperations.getAverage(intArray);

        //THEN
        assertEquals(expectedAverage, result, 1E-12);
    }

    @Test
    public void testGetAverageOneElement() {
        //GIVEN
        int[] intArray = {123};
        double expectedAverage = 123.0;

        //WHEN
        double result = ArrayOperations.getAverage(intArray);

        //THEN
        assertEquals(expectedAverage, result, 1E-12);
    }

    @Test
    public void testGetAverageNullArgument() {
        //GIVEN
        int[] intArray = null;
        try {
            //WHEN
            ArrayOperations.getAverage(intArray);
            //THEN
            fail();
        } catch (IllegalArgumentException exc) {
            //OK
        }
    }

    @Test
    public void testGetAverageEmptyArray() {
        //GIVEN
        int[] intArray = {};
        try {
            //WHEN
            ArrayOperations.getAverage(intArray);
            //THEN
            fail();
        } catch (IllegalArgumentException exc) {
            //OK
        }
    }
}
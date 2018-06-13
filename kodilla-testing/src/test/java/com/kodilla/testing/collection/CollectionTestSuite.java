package com.kodilla.testing.collection;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;


public class CollectionTestSuite {


    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Set: begin");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Test Set: end");
    }

    @Test

    public void testOddNumbersExterminatorEmptyList() {

        // Arrange
        OddNumbersExterminator exterminatorTest = new OddNumbersExterminator();
        // Act
        ArrayList<Integer> newArrayListForClassOddNumbersExterminator = new ArrayList<>();
        ArrayList<Integer> results = new ArrayList<>();
        // Assert
        Assert.assertEquals(exterminatorTest.exterminate(newArrayListForClassOddNumbersExterminator), results);
    }

    @Test

    public void testOddNumbersExterminatorNormalList() {

        // Arrange
        OddNumbersExterminator exterminatorTest = new OddNumbersExterminator();


        ArrayList<Integer> newArrayListForClassOddNumbersExterminator = new ArrayList<>();

        newArrayListForClassOddNumbersExterminator.add(2);
        newArrayListForClassOddNumbersExterminator.add(1);
        newArrayListForClassOddNumbersExterminator.add(6);
        newArrayListForClassOddNumbersExterminator.add(4);
        newArrayListForClassOddNumbersExterminator.add(20);

        // Act
        ArrayList<Integer> results = exterminatorTest.exterminate(newArrayListForClassOddNumbersExterminator);

        // Assert

        Assert.assertEquals(4, results.size());

        Assert.assertEquals(java.util.Optional.of(2), results.get(0));
        Assert.assertEquals(java.util.Optional.of(6), results.get(1));
        Assert.assertEquals(java.util.Optional.of(4), results.get(2));
        Assert.assertEquals(java.util.Optional.of(20), results.get(3));


        Assert.assertEquals(2, 2);
        Assert.assertEquals(6, 6);
        Assert.assertEquals(4, 4);
        Assert.assertEquals(20, 20);
        Assert.assertEquals(1, 1);

    }


    static public void assertEquals(String message, long expected, long actual) {
        if (expected != actual) {
            failNotEquals(message, Long.valueOf(expected), Long.valueOf(actual));
        }
    }
}
package com.kodilla.testing.collection;
import org.junit.Assert;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.AfterClass;

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

    public void testOddNumbersExterminatorEmptyList(){

        // Arrange
        OddNumbersExterminator exterminatorTest = new OddNumbersExterminator();
        // Act
        ArrayList <Integer> newArrayListForClassOddNumbersExterminator = new ArrayList<>();
        ArrayList <Integer> results = new ArrayList<>();
        // Assert
        Assert.assertEquals(exterminatorTest.exterminate(newArrayListForClassOddNumbersExterminator), results);
        }

    @Test

    public void testOddNumbersExterminatorNormalList(){

        // Arrange
        OddNumbersExterminator exterminatorTest = new OddNumbersExterminator();


        ArrayList <Integer> newArrayListForClassOddNumbersExterminator = new ArrayList<>();

        newArrayListForClassOddNumbersExterminator.add(2);
        newArrayListForClassOddNumbersExterminator.add(1);
        newArrayListForClassOddNumbersExterminator.add(6);
        newArrayListForClassOddNumbersExterminator.add(4);
        newArrayListForClassOddNumbersExterminator.add(20);

        // Act
        ArrayList <Integer> results = exterminatorTest.exterminate(newArrayListForClassOddNumbersExterminator);


        // Assert
        Assert.assertEquals( 2, 2);
        Assert.assertEquals( 6, 6);
        Assert.assertEquals( 4, 4);
        Assert.assertEquals( 20, 20);
        Assert.assertEquals( 1, 1);

    }
}
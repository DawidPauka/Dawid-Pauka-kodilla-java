package com.kodilla.testing.collection;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import java.util.Random;
import org.junit.Assert;
import java.util.ArrayList;


public class CollectionTestSuite {

    @Before
    public void before() {

        System.out.println("Case Test: ♣ BEGIN ♣ ");
    }

    @After
    public void after() {

        System.out.println("Case Test: • END • ");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {

        //Given//
        ArrayList<Integer> emptyList = new ArrayList<>();
        OddNumbersExterminator exterminator = new OddNumbersExterminator();

        //When//
        boolean result = exterminator.exterminate(emptyList).isEmpty();

        //Then//
        Assert.assertTrue(result);
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {

        //Given//
        ArrayList<Integer> theList = new ArrayList<Integer>();
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        Random theGenerator = new Random();

        for(int n=0; n<1000000; n++){
            theList.add(theGenerator.nextInt(1000000));
        }

        //When//
        boolean result1 = exterminator.exterminate(theList).contains(5671);
        boolean result2 = exterminator.exterminate(theList).contains(4893);
        boolean result3 = exterminator.exterminate(theList).contains(10001);
        boolean result4 = exterminator.exterminate(theList).contains(99999);
        boolean result5 = exterminator.exterminate(theList).contains(66669);

        //Then - sprawdzam czy lista posiada powyższe liczby nieparzyste//
        Assert.assertFalse(result1);
        Assert.assertFalse(result2);
        Assert.assertFalse(result3);
        Assert.assertFalse(result4);
        Assert.assertFalse(result5);
    }
}
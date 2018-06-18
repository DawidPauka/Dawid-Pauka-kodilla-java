package com.kodilla.testing.collection;

import java.util.ArrayList;

public class OddNumbersExterminator {

    ArrayList<Integer> exterminate(ArrayList<Integer> numbers) {

        ArrayList<Integer> result = new ArrayList<>();

        for (Integer number : numbers) {
            if ((number % 2 == 0) && result.add(number)&& (number != 0));
        }

        return result;
    }
}
package com.kodilla.stream.array;

import java.util.stream.IntStream;

public interface ArrayOperations {
    public static double getAverage(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException();
        }
        return IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .average().getAsDouble();
    }
}
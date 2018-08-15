package com.kodilla.good.patterns.challenges;

import java.util.stream.Collectors;

class PatternsMain {
    public static void main(String[] args) {
        MovieStore movieStore = new MovieStore();

        String result = movieStore.getMovies().entrySet().stream()
                .flatMap(val -> val.getValue().stream())
                .collect(Collectors.joining(" !!! "));

        System.out.println(result);
    }



}
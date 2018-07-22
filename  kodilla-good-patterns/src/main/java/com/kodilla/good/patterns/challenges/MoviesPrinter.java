package com.kodilla.good.patterns.challenges;

import java.util.stream.Collectors;

public class MoviesPrinter {
    public static void main(String[] args) {
        new MoviesPrinter().printAllTitlesAndTranslationsFrom(new MovieStore());
    }

    public void printAllTitlesAndTranslationsFrom(MovieStore movieStore) {
        if (movieStore == null) {
            throw new IllegalArgumentException("MovieStore is null");
        }
        String displayed = movieStore.getMovies().entrySet().stream()
                .flatMap(entry -> entry.getValue().stream())
                .collect(Collectors.joining("!"));
        System.out.println(displayed);
    }
}
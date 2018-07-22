package com.kodilla.good.patterns.challenges;

import java.util.*;

class MovieStore {
    private static Map<String, List<String>> movies;

    private Map<String, List<String>> prepareMovies() {
        List<String> ironManTranslations = new ArrayList<>();
        ironManTranslations.add("Żelazny Człowiek");
        ironManTranslations.add("Iron Man");

        List<String> avengersTranslations = new ArrayList<>();
        avengersTranslations.add("Mściciele");
        avengersTranslations.add("Avengers");

        List<String> flashTranslations = new ArrayList<>();
        flashTranslations.add("Błyskawica");
        flashTranslations.add("Flash");

        Map<String, List<String>> moviesTitlesWithTranslations = new HashMap<>();
        moviesTitlesWithTranslations.put("IM", ironManTranslations);
        moviesTitlesWithTranslations.put("AV", avengersTranslations);
        moviesTitlesWithTranslations.put("FL", flashTranslations);

        return moviesTitlesWithTranslations;
    }

    public MovieStore() {
    }

    public Map<String, List<String>> getMovies() {
        return movies == null ? movies = prepareMovies() : movies;
    }
}
package com.kodilla.good.patterns.challenges.flight;


public class SearchRequestRetriever {
    public SearchRequest retrieve () {
        City city = new City("GDANSK");

        return new SearchRequest(city);
    }
}
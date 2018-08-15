package com.kodilla.good.patterns.challenges.flight;


public class SearchRequest {
    private City city;

    public SearchRequest(City city) {
        this.city = city;
    }

    public City getCity() {
        return city;
    }
}
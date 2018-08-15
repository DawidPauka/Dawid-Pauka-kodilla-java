package com.kodilla.good.patterns.challenges.flight;

public interface SearchService {
    Flight searchFrom(City city);

    FlightToDto searchTo(City city);

}
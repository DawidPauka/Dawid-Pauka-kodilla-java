package com.kodilla.good.patterns.challenges.flight;

import java.util.ArrayList;
import java.util.List;

public class FlightSearchService implements SearchService {
    private List<Flight> flights;

    public FlightSearchService(List<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public Flight searchFrom(City city) {
        return flights.stream()
                .filter(f -> f.getFrom().equals(city))
                .findFirst().orElse(null);
    }

    @Override
    public FlightToDto searchTo(City city) {
        List<City> fromDirectCities = new ArrayList<>();
        List<City> viaCities = new ArrayList<>();

        //From city name
        for(Flight flightKey : flights) {
            for(City direct : flightKey.getDirect()) {
                if(city.equals(direct)) {
                    fromDirectCities.add(flightKey.getFrom());
                }
            }
        }

        //Map city target in via
        flights.stream()
                .flatMap(f -> f.getVia().entrySet().stream())
                .filter(k -> k.getKey().equals(city))
                .forEach(k -> viaCities.addAll(k.getValue()));

        return new FlightToDto(fromDirectCities, viaCities);
    }

}
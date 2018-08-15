package com.kodilla.good.patterns.challenges.flight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Flight {
    private City from;
    private Map<City, List<City>> via = new HashMap<>();
    private List<City> direct = new ArrayList<>();

    public Flight(City from) {
        this.from = from;
    }

    public City getFrom() {
        return from;
    }

    public Map<City, List<City>> getVia() {
        return via;
    }

    public List<City> getDirect() {
        return direct;
    }

    public City getDirectByCity(City city) {
        return direct.get(direct.indexOf(city));
    }

    public void addCityInWay(City cityTo, City cityInWay) {
        via.computeIfAbsent(cityTo,
                k -> new ArrayList<>()).add(cityInWay);
    }

    public void addCityAsDirect(City city) {
        direct.add(city);
    }
}
package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.*;

public class World {
    private Set<Continent> continents = new HashSet<>();

    public World() {
    }

    public void addContinent(Continent continent) {
        if (continent == null) {
            throw new IllegalArgumentException();
        }
        continents.add(continent);
    }

    public List<Continent> getContinents(){
        return new ArrayList<>(continents);
    }

    public BigDecimal getPeopleQuantity() {
        return continents.stream()
                .flatMap(continent -> continent.getCountries().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
    }
}
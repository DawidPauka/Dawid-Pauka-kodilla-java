package com.kodilla.stream.world;

import java.util.*;

public final class Continent {
    private final String name;
    private final Set<Country> countries = new HashSet<>();

    public Continent(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addCountry(Country country) {
        if (country == null) {
            throw new IllegalArgumentException();
        }
        countries.add(country);
    }

    public List<Country> getCountries(){
        return new ArrayList<>(countries);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Continent continent = (Continent) o;
        return name.equals(continent.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Continent{" +
                "name='" + name + '\'' +
                ", countries=" + countries +
                '}';
    }
}
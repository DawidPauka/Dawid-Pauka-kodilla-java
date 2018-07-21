package com.kodilla.exception.test;

import java.util.*;

class FlightPlan {
    public boolean findFlight(Flight flight) throws RouteNotFoundException {
        if (flight == null) {
            throw new IllegalArgumentException();
        }

        Map<String, Boolean> arrivalAbilities = new HashMap<>();
        arrivalAbilities.put("Singapore Changi", false);
        arrivalAbilities.put("Tokyo Intl Haneda", true);
        arrivalAbilities.put("Warszawa Airport", true);
        arrivalAbilities.put("Hong Kong Intl Airport", false);
        arrivalAbilities.put("Zurich Airport", true);
        arrivalAbilities.put("Paris Airport", true);
        arrivalAbilities.put("Frankfurt Airport", true);
        arrivalAbilities.put("Amsterdam Schiphol", true);
        arrivalAbilities.put("Bydgoszcz Airport", true);
        arrivalAbilities.put("Dubai Airport", false);
        arrivalAbilities.put("Taiwan Taoyuan Airport", false);
        arrivalAbilities.put("Vienna Airport", true);
        arrivalAbilities.put("Cologne / Bonn Airport", true);
        arrivalAbilities.put("Melbourne Airport", true);
        arrivalAbilities.put("Madrid-Barajas Airport", true);
        arrivalAbilities.put("Barcelona Airport", true);
        arrivalAbilities.put("London City Airport", true);
        arrivalAbilities.put("Johannesburg", false);
        arrivalAbilities.put("Bangkok Suvarnabhumi", false);
        arrivalAbilities.put("San Francisco Airport", false);
        arrivalAbilities.put("Bogota Airport", false);
        arrivalAbilities.put("Toronto Pearson Airport", true);
        arrivalAbilities.put("Athens Airport", true);
        arrivalAbilities.put("Oslo Airport", true);
        arrivalAbilities.put("Delhi Airport", true);
        arrivalAbilities.put("Stockholm Arlanda", true);
        arrivalAbilities.put("New York JFK Airport", true);
        arrivalAbilities.put("Lisbon Airport", true);
        arrivalAbilities.put("Minneapolis-St Paul", false);
        arrivalAbilities.put("Moscow Domodedovo", true);
        arrivalAbilities.put("Porto Airport", false);
        arrivalAbilities.put("Dublin Airport", true);
        arrivalAbilities.put("Hanoi Noi Bai Airport", false);
        arrivalAbilities.put("Budapest Airport", true);
        arrivalAbilities.put("Brussels Airport", true);

        String arrival = flight.getArrivalAirport();
        if (!arrivalAbilities.containsKey(arrival)) {
            throw new RouteNotFoundException();
        }
        return arrivalAbilities.get(arrival);
    }
}
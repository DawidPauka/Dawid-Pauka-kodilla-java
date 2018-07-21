package com.kodilla.exception.test;

import java.util.HashSet;
import java.util.Set;

public class Flights {
    public static void main(String[] args) {
        String departureAirport = "Warsaw Airport";
        Set<Flight> flights = new HashSet<>();
        flights.add(new Flight(departureAirport, "Copenhagen Airport"));
        flights.add(new Flight(departureAirport, "London City Airport"));
        flights.add(new Flight(departureAirport, "Bangkok Suvarnabhumi"));
        flights.add(new Flight(departureAirport, "Oslo Airport"));
        flights.add(new Flight(departureAirport, "Disneyland Airport"));
        flights.add(new Flight(departureAirport, "Lisbon Airport"));
        flights.add(new Flight(departureAirport, "Dubai Airport"));

        FlightPlan schedule = new FlightPlan();
        for (Flight flight : flights) {
            try {
                System.out.printf("%s: %s\n", flight,
                        schedule.findFlight(flight) ? "SCHEDULED" : "CANCELED");
            } catch (RouteNotFoundException e) {
                System.out.printf("[Error: %s does not exist]\n", flight);
            }
        }
    }
}
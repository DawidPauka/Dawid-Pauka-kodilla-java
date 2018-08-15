package com.kodilla.good.patterns.challenges.flight;

import java.util.ArrayList;
import java.util.List;

public class SearchMain {
    public static void main(String[] args) {

        List<Flight> flights = new ArrayList<>();
        Flight flight1 = new Flight(new City("GDANSK"));
        flight1.addCityAsDirect(new City("WROCLAW"));
        flight1.addCityAsDirect(new City("WARSZAWA"));
        flight1.addCityInWay(new City("RADOM"), new City("WARSZAWA"));
        flight1.addCityInWay(new City("KONIN"), new City("RADOM"));
        flight1.addCityInWay(new City("KONIN"), new City("WARSZAWA"));

        Flight flight2 = new Flight(new City("KIELCE"));
        flight2.addCityAsDirect(new City("SLASK"));

        Flight flight3 = new Flight(new City("LODZ"));
        flight3.addCityAsDirect(new City("WROCLAW"));
        flight3.addCityAsDirect(new City("BYDGOSZCZ"));
        flight3.addCityInWay(new City("GDANSK"), new City("WROCLAW"));

        flights.add(flight1);
        flights.add(flight2);

        SearchRequestRetriever searchRequestRetriever = new SearchRequestRetriever();
        SearchRequest searchRequest = searchRequestRetriever.retrieve();

        SearchProcessor searchProcessor = new SearchProcessor(
                new FlightSearchService(flights));
        searchProcessor.process(searchRequest);
    }
}
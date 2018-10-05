package com.kodilla.good.patterns.challenges.flight;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SearchTestSuite {

    @Test
    public void shouldFindAllFlightsFromGivenCity() {


        // Given

        List<Flight> flights = new ArrayList<>();
        Flight flight1 = new Flight(new City("GDANSK"));
        flight1.addCityAsDirect(new City("WARSZAWA"));
        flights.add(flight1);
        City city = new City("GDANSK");
        SearchRequest searchRequest = new SearchRequest(city);
        //When
        SearchProcessor searchProcessor = new SearchProcessor(new FlightSearchService(flights));
        SearchDto result = searchProcessor.process(searchRequest);
        //Then
        Flight resultFlight = result.getTimetableFrom();
        City cityFrom = resultFlight.getFrom();

        Assert.assertEquals(new City("GDANSK"), cityFrom);
        List<City> resultDirectCities = resultFlight.getDirect();
        Assert.assertTrue(resultDirectCities.size() == 1);
        Assert.assertEquals(new City("WARSZAWA"), resultDirectCities.get(0));

    }


    @Test
    public void shouldFindAllFlightsToCity() {


        // Given

        List<Flight> flights = new ArrayList<>();
        Flight flight1 = new Flight(new City("GDANSK"));
        List<City> direct = new ArrayList<>();
        City city1 = new City("WARSZAWA");
        direct.add(city1);
        System.out.println(city1);

        flight1.addCityAsDirect(new City("WARSZAWA"));


        flights.add(flight1);

        City city = new City("GDANSK");
        System.out.println(city);
        SearchRequest searchRequest = new SearchRequest(city);
        System.out.println(searchRequest);

        //When
        SearchProcessor searchProcessor = new SearchProcessor(new FlightSearchService(flights));
        SearchDto result = searchProcessor.process(searchRequest);

        //Then
        FlightToDto resultFlightDto = result.getTimetableTo ();

        Assert.assertEquals(city1,new City("WARSZAWA"));


    }
}





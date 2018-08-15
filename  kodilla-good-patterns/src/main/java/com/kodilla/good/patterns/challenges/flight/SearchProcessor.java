package com.kodilla.good.patterns.challenges.flight;


public class SearchProcessor {
    private SearchService searchService;

    public SearchProcessor(SearchService searchService) {
        this.searchService = searchService;
    }

    public SearchDto process(SearchRequest searchRequest) {
        System.out.println("Start processing order");

        Flight timetableFrom = searchService.searchFrom(searchRequest.getCity());
        FlightToDto timetableTo = searchService.searchTo(searchRequest.getCity());

        System.out.println("Successfully finish processing order");
        return new SearchDto(timetableFrom, timetableTo);
    }
}
package com.kodilla.good.patterns.challenges.flight;


public class SearchDto {
    private Flight timetableFrom;
    private FlightToDto timetableTo;

    public SearchDto(Flight timetableFrom, FlightToDto timetableTo) {
        this.timetableFrom = timetableFrom;
        this.timetableTo = timetableTo;
    }

    public Flight getTimetableFrom() {
        return timetableFrom;
    }



    public FlightToDto getTimetableTo() {
        return timetableTo;
    }
}
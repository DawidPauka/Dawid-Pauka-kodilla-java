package com.kodilla.exception.test;

public final class Flight {
    private final String departureAirport;
    private final String arrivalAirport;

    public Flight(final String departureAirport, final String arrivalAirport) {
        if (departureAirport == null || departureAirport.isEmpty()
                || arrivalAirport == null || arrivalAirport.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        if (!departureAirport.equals(flight.departureAirport)) return false;
        return arrivalAirport.equals(flight.arrivalAirport);
    }

    @Override
    public int hashCode() {
        int result = departureAirport.hashCode();
        result = 31 * result + arrivalAirport.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Flight from " +
                "'" + departureAirport + '\'' +
                " to '" + arrivalAirport + '\'';
    }
}
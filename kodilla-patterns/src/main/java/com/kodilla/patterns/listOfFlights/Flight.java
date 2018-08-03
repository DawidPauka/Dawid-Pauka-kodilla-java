package flights;

import java.time.LocalTime;
import java.util.Objects;

public class Flight {
    private String number;
    private String departureAirport;
    private LocalTime departureTime;
    private String arrivalAirport;
    private LocalTime arrivalTime;

    public Flight(String number, String departureAirport, LocalTime departureTime, String arrivalAirport, LocalTime arrivalTime) {
        this.number = number;
        this.departureAirport = departureAirport;
        this.departureTime = departureTime;
        this.arrivalAirport = arrivalAirport;
        this.arrivalTime = arrivalTime;
    }

    public String getNumber() {
        return number;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(number, flight.number) &&
                Objects.equals(departureAirport, flight.departureAirport) &&
                Objects.equals(departureTime, flight.departureTime) &&
                Objects.equals(arrivalAirport, flight.arrivalAirport) &&
                Objects.equals(arrivalTime, flight.arrivalTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(number, departureAirport, departureTime, arrivalAirport, arrivalTime);
    }
}
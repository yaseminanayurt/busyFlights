package com.travix.medusa.busyflights.domain.busyflights;


import com.travix.medusa.busyflights.domain.AbstractRequest;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

public class BusyFlightsRequest extends AbstractRequest {

    @NotBlank(message = "Origin should be three letters long!")
    @Size(min = 3, max = 3)
    private String origin;

    @NotBlank(message = "Destination should be three letters long!")
    @Size(min = 3, max = 3)
    private String destination;

    //TODO: departureDate should be less than ReturnDate Validator should be added!
    private String departureDate;

    private String returnDate;
    private int numberOfPassengers;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(final String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(final String destination) {
        this.destination = destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(final String departureDate) {
        this.departureDate = departureDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(final String returnDate) {
        this.returnDate = returnDate;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(final int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }
}

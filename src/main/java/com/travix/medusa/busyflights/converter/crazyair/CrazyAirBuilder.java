package com.travix.medusa.busyflights.converter.crazyair;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;

/**
 * Created by eanayas on 07.02.2018.
 */
public class CrazyAirBuilder {

    public static CrazyAirRequest buildRequest(BusyFlightsRequest busyFlightsRequest) {

        CrazyAirRequest crazyAirRequest = new CrazyAirRequest();
        crazyAirRequest.setDepartureDate(busyFlightsRequest.getDepartureDate());
        crazyAirRequest.setReturnDate(busyFlightsRequest.getReturnDate());
        crazyAirRequest.setDestination(busyFlightsRequest.getDestination());
        crazyAirRequest.setOrigin(busyFlightsRequest.getOrigin());
        crazyAirRequest.setPassengerCount(busyFlightsRequest.getNumberOfPassengers());
        return crazyAirRequest;

    }

    protected static BusyFlightsResponse buildResponse(CrazyAirResponse crazyAirResponse){
        BusyFlightsResponse busyFlightsResponse = new BusyFlightsResponse();
        busyFlightsResponse.setSupplier("Crazy Air");
        busyFlightsResponse.setAirline(crazyAirResponse.getAirline());
        busyFlightsResponse.setDepartureAirportCode(crazyAirResponse.getDepartureAirportCode());
        busyFlightsResponse.setArrivalDate(crazyAirResponse.getArrivalDate());
        busyFlightsResponse.setDestinationAirportCode(crazyAirResponse.getDestinationAirportCode());
        busyFlightsResponse.setFare(String.valueOf(crazyAirResponse.getPrice()));
        return busyFlightsResponse;
    }
}

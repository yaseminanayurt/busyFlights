package com.travix.medusa.busyflights.converter.toughjet;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;

/**
 * Created by eanayas on 07.02.2018.
 */
public class ToughJetBuilder {

    public static ToughJetRequest buildRequest(BusyFlightsRequest busyFlightsRequest) {

        ToughJetRequest toughJetRequest = new ToughJetRequest();
        toughJetRequest.setInboundDate(busyFlightsRequest.getDepartureDate());
        toughJetRequest.setOutboundDate(busyFlightsRequest.getReturnDate());
        toughJetRequest.setTo(busyFlightsRequest.getDestination());
        toughJetRequest.setFrom(busyFlightsRequest.getOrigin());
        toughJetRequest.setNumberOfAdults(busyFlightsRequest.getNumberOfPassengers());

        return toughJetRequest;

    }

    public static BusyFlightsResponse buildResponse(ToughJetResponse toughJetResponse) {

        BusyFlightsResponse busyFlightsResponse = new BusyFlightsResponse();
        busyFlightsResponse.setSupplier("Tough Jet Supplier");
        busyFlightsResponse.setAirline(toughJetResponse.getCarrier());
        busyFlightsResponse.setDepartureAirportCode(toughJetResponse.getDepartureAirportName());
        busyFlightsResponse.setArrivalDate(toughJetResponse.getInboundDateTime());
        busyFlightsResponse.setDepartureDate(toughJetResponse.getOutboundDateTime());
        busyFlightsResponse.setDestinationAirportCode(toughJetResponse.getArrivalAirportName());
        double price = getDiscountPrice(toughJetResponse.getBasePrice(),toughJetResponse.getDiscount(),toughJetResponse.getTax());
        busyFlightsResponse.setFare(String.valueOf(price));
        return busyFlightsResponse;

    }


    private static double getDiscountPrice(double basePrice, double discount,double tax) {
        return basePrice + tax - discount ;
    }
}

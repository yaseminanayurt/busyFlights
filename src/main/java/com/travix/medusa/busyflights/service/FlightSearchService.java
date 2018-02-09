package com.travix.medusa.busyflights.service;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;

import java.util.List;

/**
 * Created by eanayas on 07.02.2018.
 */
public interface FlightSearchService {
    List<BusyFlightsResponse> searchFlights(BusyFlightsRequest busyFlightsRequest);
}

package com.travix.medusa.busyflights.handler;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;

import java.util.List;

/**
 * Created by eanayas on 07.02.2018.
 */
public interface SearchHandler {

    List<BusyFlightsResponse> search(final BusyFlightsRequest request);

}

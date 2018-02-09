package com.travix.medusa.busyflights.service;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.handler.SearchHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by eanayas on 07.02.2018.
 */
@Component
public class BusyFlightsSearchService implements FlightSearchService {
    @Resource
    List<SearchHandler> busyFlightsSearchHandler;

    @Override
    public List<BusyFlightsResponse> searchFlights(BusyFlightsRequest busyFlightsRequest) {

         List<BusyFlightsResponse> responseList =  busyFlightsSearchHandler
                .stream()
                .map(searchHandler -> searchHandler.search(busyFlightsRequest))
                .flatMap(Collection::parallelStream)
                .sorted(Comparator.comparing(busyFlightsResponse -> Double.valueOf(busyFlightsResponse.getFare())))
                .collect(Collectors.toList());

        return responseList;
    }
}

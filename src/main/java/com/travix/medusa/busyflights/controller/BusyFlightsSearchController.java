package com.travix.medusa.busyflights.controller;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.service.FlightSearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by eanayas on 07.02.2018.
 */
@RestController
@RequestMapping("/busyFlights")
public class BusyFlightsSearchController {

    @Resource
    private FlightSearchService flightSearchService;

    private final Logger logger = LoggerFactory.getLogger(BusyFlightsSearchController.class);


    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ResponseEntity<List<BusyFlightsResponse>> search(@Valid BusyFlightsRequest request) {

        final List<BusyFlightsResponse> busyFlightsResponseList;
        try {

            busyFlightsResponseList = flightSearchService.searchFlights(request);
            return new ResponseEntity(busyFlightsResponseList, HttpStatus.OK);

        } catch (Exception e) {
            logger.error("Error occured!", e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

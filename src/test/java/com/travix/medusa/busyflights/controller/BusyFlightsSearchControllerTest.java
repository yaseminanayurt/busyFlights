package com.travix.medusa.busyflights.controller;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.service.FlightSearchService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by eanayas on 07.02.2018.
 */
public class BusyFlightsSearchControllerTest {

    @InjectMocks
    private BusyFlightsSearchController busyFlightsSearchController;

    @Mock
    private FlightSearchService flightSearchService;;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void searchTest() throws Exception {

        BusyFlightsRequest busyFlightsRequest = new BusyFlightsRequest();
        BusyFlightsResponse busyFlightsResponse1 = new BusyFlightsResponse();
        busyFlightsResponse1.setSupplier("TEST");

        BusyFlightsResponse busyFlightsResponse2 = new BusyFlightsResponse();
        busyFlightsResponse2.setAirline("THY");

        when(flightSearchService.searchFlights(busyFlightsRequest)).thenReturn(Arrays.asList( busyFlightsResponse1,busyFlightsResponse2));

        ResponseEntity<List<BusyFlightsResponse>> result =
                busyFlightsSearchController.search(busyFlightsRequest);
        System.out.println(result.getBody().get(0).getSupplier());

        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(2, result.getBody().size());
        Assert.assertEquals("TEST", result.getBody().get(0).getSupplier());
        Assert.assertEquals("THY", result.getBody().get(1).getAirline());

    }
}
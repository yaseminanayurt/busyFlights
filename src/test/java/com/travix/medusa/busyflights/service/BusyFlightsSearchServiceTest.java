package com.travix.medusa.busyflights.service;

import com.travix.medusa.busyflights.handler.SearchHandler;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Created by eanayas on 07.02.2018.
 */
public class BusyFlightsSearchServiceTest {
    @InjectMocks
    private BusyFlightsSearchService busyFlightsSearchService;

    @Mock
    private SearchHandler searchHandler;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void searchFlights() throws Exception {


    }

}
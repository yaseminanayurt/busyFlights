package com.travix.medusa.busyflights.converter.crazyair;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * Created by eanayas on 07.02.2018.
 */
@Component("crazyAirRequestConverter")
public class CrazyAirRequestConverter implements Function<BusyFlightsRequest,CrazyAirRequest> {

    @Override
    public CrazyAirRequest apply(BusyFlightsRequest busyFlightsRequest) {
        return CrazyAirBuilder.buildRequest(busyFlightsRequest);
    }
}

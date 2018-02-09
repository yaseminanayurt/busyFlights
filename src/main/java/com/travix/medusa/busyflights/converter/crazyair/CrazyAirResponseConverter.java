package com.travix.medusa.busyflights.converter.crazyair;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * Created by eanayas on 07.02.2018.
 */
@Component("crazyAirBusyFlightResponseConverter")
public class CrazyAirResponseConverter implements Function<CrazyAirResponse,BusyFlightsResponse> {
    @Override
    public BusyFlightsResponse apply(CrazyAirResponse crazyAirResponse) {
        return CrazyAirBuilder.buildResponse(crazyAirResponse);
    }
}

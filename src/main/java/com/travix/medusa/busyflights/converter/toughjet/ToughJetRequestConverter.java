package com.travix.medusa.busyflights.converter.toughjet;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * Created by eanayas on 07.02.2018.
 */
@Component("toughJetFlightRequestConverter")
public class ToughJetRequestConverter implements Function<BusyFlightsRequest,ToughJetRequest> {

    @Override
    public ToughJetRequest apply(BusyFlightsRequest busyFlightsRequest) {

       return ToughJetBuilder.buildRequest(busyFlightsRequest);
    }
}
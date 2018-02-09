package com.travix.medusa.busyflights.converter.toughjet;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * Created by eanayas on 07.02.2018.
 */
@Component(("toughJetFlightResponseConverter"))
public class ToughJetResponseConverter implements Function<ToughJetResponse,BusyFlightsResponse> {

    @Override
    public BusyFlightsResponse apply(ToughJetResponse toughJetResponse) {

        return ToughJetBuilder.buildResponse(toughJetResponse);
    }


}

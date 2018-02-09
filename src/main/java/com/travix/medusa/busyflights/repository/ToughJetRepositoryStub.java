package com.travix.medusa.busyflights.repository;

import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eanayas on 07.02.2018.
 */
@Component
public class ToughJetRepositoryStub implements Repository<ToughJetRequest,ToughJetResponse> {

    @Override
    public List<ToughJetResponse> getFlights(ToughJetRequest toughJetRequest){


        List<ToughJetResponse> toughJetResponseList = new ArrayList<>();
        ToughJetResponse toughJetResponse1 = new ToughJetResponse();
        toughJetResponse1.setCarrier("LUF");
        toughJetResponse1.setArrivalAirportName(toughJetRequest.getFrom());
        toughJetResponse1.setDepartureAirportName(toughJetRequest.getTo());
        toughJetResponse1.setBasePrice(700);
        toughJetResponse1.setDiscount(70);
        toughJetResponse1.setTax(35);
        toughJetResponseList.add(toughJetResponse1);

        ToughJetResponse toughJetResponse2 = new ToughJetResponse();

        toughJetResponse2.setCarrier("THY");
        toughJetResponse2.setArrivalAirportName(toughJetRequest.getFrom());
        toughJetResponse2.setDepartureAirportName(toughJetRequest.getTo());
        toughJetResponse2.setBasePrice(850);
        toughJetResponse2.setDiscount(100);
        toughJetResponse2.setTax(35);
        toughJetResponseList.add(toughJetResponse2);
        return  toughJetResponseList;
    }

}

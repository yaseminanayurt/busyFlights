package com.travix.medusa.busyflights.repository;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eanayas on 07.02.2018.
 */
@Component
public class CrazyAirRepositoryStub implements Repository<CrazyAirRequest,CrazyAirResponse>{

    @Override
    public List<CrazyAirResponse> getFlights(CrazyAirRequest crazyAirRequest){

        List<CrazyAirResponse> crazyAirResponseList = new ArrayList<>();
        CrazyAirResponse crazyAirResponse1 = new CrazyAirResponse();
        crazyAirResponse1.setAirline("CO");
        crazyAirResponse1.setCabinclass("E");
        crazyAirResponse1.setDepartureAirportCode(crazyAirRequest.getOrigin());
        crazyAirResponse1.setDestinationAirportCode(crazyAirRequest.getDestination());
        crazyAirResponse1.setPrice(1700);
        crazyAirResponseList.add(crazyAirResponse1);

        final CrazyAirResponse crazyAirResponse2 = new CrazyAirResponse();
        crazyAirResponse2.setAirline("CX");
        crazyAirResponse2.setCabinclass("B");
        crazyAirResponse2.setDepartureAirportCode(crazyAirRequest.getOrigin());
        crazyAirResponse2.setDestinationAirportCode(crazyAirRequest.getDestination());
        crazyAirResponse2.setPrice(305);

        crazyAirResponseList.add(crazyAirResponse2);
        return  crazyAirResponseList;
    }
}

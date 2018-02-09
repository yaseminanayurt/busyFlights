package com.travix.medusa.busyflights.supplier;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by eanayas on 07.02.2018.
 */
@Component("crazyAirSupplier")
public class CrazyAirSupplier extends BaseRestClient<CrazyAirRequest,CrazyAirResponse> {

    @Value("${search.endpoint.crazyair}")
    private String endpoint;

    @Override
    Class<CrazyAirResponse[]> getResponseClass() {
        System.out.println("getResponseClass()");
        return CrazyAirResponse[].class;
    }

    @Override
    public String getEndpoint() {
        return endpoint;
    }


}

package com.travix.medusa.busyflights.handler;

import com.travix.medusa.busyflights.domain.AbstractRequest;
import com.travix.medusa.busyflights.domain.AbstractResponse;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.supplier.BaseRestClient;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by eanayas on 07.02.2018.
 */
public class BusyFlightsSearchHandler implements SearchHandler {

    private Function<BusyFlightsRequest, AbstractRequest> requestConverter;
    private Function<AbstractResponse, BusyFlightsResponse> responseConverter;

    public void setRequestConverter(Function<BusyFlightsRequest, AbstractRequest> requestConverter) {
        this.requestConverter = requestConverter;
    }

    public void setResponseConverter(Function<AbstractResponse, BusyFlightsResponse> responseConverter) {
        this.responseConverter = responseConverter;
    }

    public void setFlightSupplier(BaseRestClient flightSupplier) {
        this.flightSupplier = flightSupplier;
    }

    private BaseRestClient flightSupplier;


    @Override
    public List<BusyFlightsResponse> search(final BusyFlightsRequest request){

        AbstractRequest supplierRequest = requestConverter.apply(request);
        List<AbstractResponse> supplierResponseList =  flightSupplier.getResponse(supplierRequest);
        return supplierResponseList.stream().map(supplierResponse-> responseConverter.apply(supplierResponse)).collect(Collectors.toList());
    }
}

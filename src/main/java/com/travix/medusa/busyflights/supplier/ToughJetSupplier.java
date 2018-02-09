package com.travix.medusa.busyflights.supplier;

import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by eanayas on 07.02.2018.
 */
@Component("toughJetSupplier")
public class ToughJetSupplier extends BaseRestClient<ToughJetRequest,ToughJetResponse> {
    @Value("${search.endpoint.toughjet}")
    private String endpoint;

    @Override
    Class<ToughJetResponse[]> getResponseClass() {
        return ToughJetResponse[].class;
    }

    @Override
    public String getEndpoint() {
        return endpoint;
    }


}


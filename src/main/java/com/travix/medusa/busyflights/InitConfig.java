package com.travix.medusa.busyflights;

import com.travix.medusa.busyflights.domain.AbstractRequest;
import com.travix.medusa.busyflights.domain.AbstractResponse;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.supplier.BaseRestClient;
import com.travix.medusa.busyflights.handler.BusyFlightsSearchHandler;
import com.travix.medusa.busyflights.handler.SearchHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.Resource;
import java.util.function.Function;

/**
 * Created by eanayas on 07.02.2018.
 */
@Configuration
@EnableWebMvc
public class InitConfig {

    @Bean(name = "busyFlightsRestTemplate")
    public RestTemplate busyFlightsRestTemplate() {
        return new RestTemplate();
    }

    @Resource(name = "crazyAirSupplier")
    private BaseRestClient<CrazyAirRequest, CrazyAirResponse> crazyAirSupplier;

    @Resource(name = "toughJetSupplier")
    private BaseRestClient<ToughJetRequest, ToughJetResponse> toughJetAirSupplier;

    @Resource(name = "toughJetFlightRequestConverter")
    private Function<BusyFlightsRequest,AbstractRequest> toughJetRequestConverter;

    @Resource(name = "toughJetFlightResponseConverter")
    private Function<AbstractResponse,BusyFlightsResponse> toughJetResponseConverter;

    @Resource(name = "crazyAirRequestConverter")
    private Function<BusyFlightsRequest,AbstractRequest> crazyAirRequestConverter;

    @Resource(name = "crazyAirBusyFlightResponseConverter")
    private Function<AbstractResponse,BusyFlightsResponse> crazyAirResponseConverter;

    @Bean(name = "crazyJetSearchHandler")
    public SearchHandler crazyJetSearchHandler() {
        BusyFlightsSearchHandler searchHandler = new BusyFlightsSearchHandler();
        searchHandler.setFlightSupplier(crazyAirSupplier);
        searchHandler.setRequestConverter(crazyAirRequestConverter);
        searchHandler.setResponseConverter(crazyAirResponseConverter);
        return searchHandler;
    }

    @Bean(name = "toughJetSearchHandler")
    public SearchHandler toughJetSearchHandler() {
        BusyFlightsSearchHandler searchHandler = new BusyFlightsSearchHandler();
        searchHandler.setFlightSupplier(toughJetAirSupplier);
        searchHandler.setRequestConverter(toughJetRequestConverter);
        searchHandler.setResponseConverter(toughJetResponseConverter);
        return searchHandler;
    }



}

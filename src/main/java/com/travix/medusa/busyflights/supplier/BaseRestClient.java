package com.travix.medusa.busyflights.supplier;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.springframework.web.util.UriComponentsBuilder.fromHttpUrl;

/**
 * Created by eanayas on 07.02.2018.
 */
public abstract class BaseRestClient<SupplierRequest,SupplierResponse> {

    @Resource
    private ObjectMapper objectMapper;

    @Resource(name = "busyFlightsRestTemplate")
    private RestTemplate restTemplate;


    abstract String getEndpoint();
    abstract Class<SupplierResponse[]> getResponseClass();

    public List<SupplierResponse> getResponse(final SupplierRequest request) {

        final URI uri = getURI(request);
        return Arrays.asList(restTemplate.getForObject(uri, getResponseClass()));
    }

    URI getURI(final SupplierRequest request){
        final String endpoint = getEndpoint();
        Map<String, String> map =
                objectMapper.convertValue(request, new TypeReference<Map<String, String>>() {});

        LinkedMultiValueMap<String, String> linkedMultiValueMap = new LinkedMultiValueMap<>();
        map.forEach((key,value)->linkedMultiValueMap.add(key,value));
        return fromHttpUrl(endpoint).queryParams(linkedMultiValueMap).build().toUri();
    }

}

package com.travix.medusa.busyflights.controller;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.repository.CrazyAirRepositoryStub;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by eanayas on 07.02.2018.
 */
@RestController
@RequestMapping("/crazyAir")
public class CrazyAirSearchController {

    @Resource
    private CrazyAirRepositoryStub crazyAirRepositoryStub;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ResponseEntity<List<CrazyAirResponse>> search(@Valid CrazyAirRequest request) {

        List<CrazyAirResponse> crazyAirResponseList = crazyAirRepositoryStub.getFlights(request);
        return new ResponseEntity(crazyAirResponseList, HttpStatus.OK);

    }

}

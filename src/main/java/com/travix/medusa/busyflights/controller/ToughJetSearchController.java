package com.travix.medusa.busyflights.controller;

import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.repository.ToughJetRepositoryStub;
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
@RequestMapping("/toughJet")
public class ToughJetSearchController {

    @Resource
    private ToughJetRepositoryStub toughJetRepositoryStub;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ResponseEntity<List<ToughJetResponse>> search(@Valid ToughJetRequest request) {

        List<ToughJetResponse> toughJetResponses = toughJetRepositoryStub.getFlights(request);
        return new ResponseEntity(toughJetResponses, HttpStatus.OK);


    }
}

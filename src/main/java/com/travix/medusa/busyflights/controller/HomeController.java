package com.travix.medusa.busyflights.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by eanayas on 07.02.2018.
 */

@RestController
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "Welcome to Busy Flights Home!";
    }


}

package com.reader.reader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.reader.reader.service.DataReaderService;

@RestController
@RequestMapping("/data-reader")
public class DataReaderController {

    @Autowired
    private DataReaderService dataReaderService;

    @PostMapping
    public String getData(@RequestBody TickerRequest tickerRequest) {
        // Read data from Redis based on the ticker
        return dataReaderService.getMarketData(tickerRequest.getTicker());
    }
}


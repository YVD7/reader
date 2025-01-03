package com.reader.reader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

@Service
public class DataReaderService {

    @Autowired
    private Jedis jedis;

    public String getMarketData(String ticker) {
        // Fetch the data from Redis by the ticker key
        String jsonData = jedis.get(ticker);
        if (jsonData == null) {
            return "No data found for ticker: " + ticker;
        }
        return jsonData;
    }
}


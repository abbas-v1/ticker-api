package com.company.service;

import com.company.db.TickerRepository;
import com.company.entity.Ticker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TickerService {

    @Autowired
    private TickerRepository tickerRepository;

    private static final Logger LOG = LogManager.getLogger(TickerService.class);

    public List getTickers() {
        List<Ticker> tickers = tickerRepository.findAll();
        LOG.info("List of tickers : {}", tickers);
        return tickers;
    }

    public void saveTickerData(List<List<Integer>> tickerData) {
        for (List<Integer> list : tickerData) {
            Ticker saved = tickerRepository.save(mapToTicker(list));
            LOG.info("Ticker saved : {}", saved);
        }
    }

    private Ticker mapToTicker(List<Integer> list) {
        return Ticker.builder()
                .id(new Date().getTime())
                .channelId(list.get(0))
                .bid(list.get(1))
                .bidSize(list.get(2))
                .ask(list.get(3))
                .askSize(list.get(4))
                .dailyChange(list.get(5))
                .dailyChangePerc(list.get(6))
                .lastPrice(list.get(7))
                .volume(list.get(8))
                .high(list.get(9))
                .low(list.get(10))
                .build();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.rest;

import com.company.db.TickerDao;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author abbas
 */
@RestController
public class TickerController {

    @Autowired
    private TickerDao tickerDao;
    private static final Logger LOG = LogManager.getLogger(TickerController.class);

    @PostMapping("/ticker")
    @CrossOrigin(origins = "https://angular-app-227305.appspot.com")
    public void postTickerData(@RequestBody List<List<Integer>> tickerList) {
        LOG.debug("Received data from ticker : " + tickerList.size() );
        tickerDao.saveTickerData(tickerList);
    }

    @GetMapping("/ticker")
    public List getTickerData() {
        LOG.debug("getTickerData is called");
        return tickerDao.getTickers();
    }

}

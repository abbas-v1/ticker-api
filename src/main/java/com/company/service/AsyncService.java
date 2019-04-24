package com.company.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author abbas
 */
@Service
public class AsyncService {

    @Autowired
    RestTemplate restTemplate;

    private static final Logger LOG = LogManager.getLogger();

    @Async
    public void callingRestService() {
        LOG.info("Service is reached");
        String response = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", String.class);
        LOG.info("Long running service completed : " + response);
    }

}

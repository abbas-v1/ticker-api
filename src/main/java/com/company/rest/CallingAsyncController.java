/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.rest;

import com.company.dto.UserV1;
import com.company.service.AsyncService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author abbas
 */
@RestController
public class CallingAsyncController {

    @Autowired
    private AsyncService asyncService;
    private static final Logger LOG = LogManager.getLogger();

    @PostMapping("/async")
    public void postData(@RequestBody UserV1 user) {
        LOG.debug("Received user data : " + user.getFirstName());
        asyncService.callingRestService();
        LOG.debug("Completed everything");
    }

}

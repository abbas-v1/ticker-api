/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author abbas
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    /**
     * Test of main method, of class Application.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testMain() {
        String[] args = null;
        Application.main(args);
    }
    
}


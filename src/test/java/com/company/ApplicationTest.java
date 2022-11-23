/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;


import org.junit.jupiter.api.Test;

/**
 *
 * @author abbas
 */
public class ApplicationTest {

    /**
     * Test of main method, of class Application.
     */
    @Test
    public void testMain() {
        String[] args = null;
        org.junit.jupiter.api.Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> Application.main(args)
        );
    }
    
}


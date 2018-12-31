/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.rest;

import com.company.dto.UserV1;
import com.company.dto.UserV2;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author abbas
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Autowired
    private UserController controller;

    @Test
    public void contexLoads() throws Exception {
        assertNotNull("User Controller is not null", controller);
    }

    /**
     * Test of getUsersV1 method, of class UserController.
     */
    @Test(expected = NullPointerException.class)
    public void testGetUsersV1_withNullParam() {
        Optional<String> param = null;
        controller.getUsersV1(param);
    }

    /**
     * Test of getUsersV1 method, of class UserController.
     */
    @Test
    public void testGetUsersV1() {
        Optional<String> param = Optional.empty();
        List<UserV1> result = controller.getUsersV1(param);
        assertNotNull(result);
    }
    
    /**
     * Test of getUsersV1 method, of class UserController.
     */
    @Test
    public void testGetUsersV1_notExistingName() {
        Optional<String> param = Optional.of("NotAValidName");
        List<UserV1> result = controller.getUsersV1(param);
        assertNotNull(result);
        assertEquals(0, result.size());
    }

    /**
     * Test of getUsersV2 method, of class UserController.
     */
    @Test(expected = NullPointerException.class)
    public void testGetUsersV2_withNullParam() {
        Optional<String> param = null;
        controller.getUsersV2(param);
    }

    /**
     * Test of getUsersV2 method, of class UserController.
     */
    @Test
    public void testGetUsersV2() {
        Optional<String> param = Optional.empty();
        List<UserV2> result = controller.getUsersV2(param);
        assertNotNull(result);
    }
    
        /**
     * Test of getUsersV2 method, of class UserController.
     */
    @Test
    public void testGetUsersV2_withValue() {
        Optional<String> param = Optional.empty();
        List<UserV2> result = controller.getUsersV2(param);
        assertNotNull(result.get(0).getFirstName());
        assertNotNull(result.get(0).getLastName());
        assertNotNull(result.get(0).getUserId());
        assertNotNull(result.get(0).getRegistration());
    }

}

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
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author abbas
 */
@SpringBootTest
public class UserControllerTest {

    @Autowired
    private UserController controller;

    @Test
    public void contexLoads() throws Exception {
        Assertions.assertThat(controller).isNotNull();
    }

    /**
     * Test of getUsersV1 method, of class UserController.
     */
    @Test
    public void testGetUsersV1_withNullParam() {
        Optional<String> param = null;
        org.junit.jupiter.api.Assertions.assertThrows(
                NullPointerException.class,
                () -> controller.getUsersV1(param)
        );
    }

    /**
     * Test of getUsersV1 method, of class UserController.
     */
    @Test
    public void testGetUsersV1() {
        Optional<String> param = Optional.empty();
        List<UserV1> result = controller.getUsersV1(param);
        Assertions.assertThat(result).isNotNull().hasSize(4);
    }

    /**
     * Test of getUsersV1 method, of class UserController.
     */
    @Test
    public void testGetUsersV1_ExistingName() {
        Optional<String> param = Optional.of("Abbas");
        List<UserV1> result = controller.getUsersV1(param);
        Assertions.assertThat(result).isNotNull().hasSize(1);
    }

    /**
     * Test of getUsersV1 method, of class UserController.
     */
    @Test
    public void testGetUsersV1_notExistingName() {
        Optional<String> param = Optional.of("NotAValidName");
        List<UserV1> result = controller.getUsersV1(param);
        Assertions.assertThat(result).isNotNull().hasSize(0);
    }

    /**
     * Test of getUsersV2 method, of class UserController.
     */
    @Test
    public void testGetUsersV2_withNullParam() {
        Optional<String> param = null;
        org.junit.jupiter.api.Assertions.assertThrows(
                NullPointerException.class,
                () -> controller.getUsersV2(param)
        );
    }

    /**
     * Test of getUsersV2 method, of class UserController.
     */
    @Test
    public void testGetUsersV2() {
        Optional<String> param = Optional.empty();
        List<UserV2> result = controller.getUsersV2(param);
        Assertions.assertThat(result).isNotNull().hasSize(4);
    }
    
        /**
     * Test of getUsersV2 method, of class UserController.
     */
    @Test
    public void testGetUsersV2_withValue() {
        Optional<String> param = Optional.empty();
        List<UserV2> result = controller.getUsersV2(param);
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.get(0)).isNotNull();
        Assertions.assertThat(result.get(0).getFirstName()).isNotNull();
        Assertions.assertThat(result.get(0).getLastName()).isNotNull();
        Assertions.assertThat(result.get(0).getUserId()).isNotNull();
        Assertions.assertThat(result.get(0).getRegistration()).isNotNull();
    }

}

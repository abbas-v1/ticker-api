/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.rest;

import com.company.db.UserDao;
import com.company.dto.UserV1;
import com.company.dto.UserV2;
import com.company.entity.Users;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author abbas
 */
@RestController
public class UserController {

    @Autowired
    private UserDao userDao;
    private static final Logger LOG = LogManager.getLogger(UserController.class);

    @GetMapping("/v1/users")
    public List<UserV1> getUsersV1(@RequestParam("name") Optional<String> param) {
        LOG.debug("getUsers v1 is called");
        List<Users> users = userDao.getUsers(param);
        return mapUsers(users, this::toUserV1);
    }

    @GetMapping("/v2/users")
    public List<UserV2> getUsersV2(@RequestParam("name") Optional<String> param) {
        LOG.debug("getUsers v2 is called");
        List<Users> users = userDao.getUsers(param);
        return mapUsers(users, this::toUserV2);
    }

    private <T, S> List<S> mapUsers(List<T> users, Function<T, S> mapper) {
        return users.stream()
                .map(mapper)
                .collect(Collectors.toList());
    }

    private UserV1 toUserV1(Users user) {
        UserV1 userV1 = new UserV1();
        userV1.setFirstName(user.getFirstName());
        userV1.setLastName(user.getLastName());
        return userV1;
    }

    private UserV2 toUserV2(Users user) {
        UserV2 userV2 = new UserV2();
        userV2.setUserId(user.getUserId());
        userV2.setFirstName(user.getFirstName());
        userV2.setLastName(user.getLastName());
        userV2.setRegistration(user.getRegistration());
        return userV2;
    }

}

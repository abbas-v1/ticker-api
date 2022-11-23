package com.company.service;

import com.company.db.UserDao;
import com.company.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<Users> getUsers(Optional<String> param) {


        if (param.isPresent()) {
            return userDao.findByFirstName(param.get());
        }

        return userDao.findAll();
    }
}

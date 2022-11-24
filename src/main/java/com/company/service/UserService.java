package com.company.service;

import com.company.db.UsersRepository;
import com.company.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UsersRepository usersRepository;

    public List<Users> getUsers(Optional<String> param) {


        if (param.isPresent()) {
            return usersRepository.findByFirstName(param.get());
        }

        return usersRepository.findAll();
    }
}

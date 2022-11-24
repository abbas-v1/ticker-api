package com.company.db;

import com.company.entity.Users;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface UsersRepository extends Repository<Users, Long> {

    @Query("select * from users where first_name = :firstName")
    List<Users> findByFirstName(String firstName);

    List<Users> findAll();

}

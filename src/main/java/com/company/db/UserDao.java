/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.db;

import com.company.entity.Users;
import java.util.List;
import java.util.Optional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 *
 * @author abbas
 */
@Repository
public class UserDao {

    public List<Users> getUsers(Optional<String> param) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query;
        if (param.isPresent()) {
            query = session.createQuery( "from Users where firstName = :name or lastName = :name" );
            query.setParameter("name", param.get());
        } else {
            query = session.createQuery( "from Users" );
        }
        
        List<Users> list = (List<Users>) query.list();
        session.close();
        return list;
    }
    
}

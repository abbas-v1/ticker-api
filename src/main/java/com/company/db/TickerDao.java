package com.company.db;

import com.company.entity.Ticker;
import com.company.entity.Users;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface TickerDao extends CrudRepository<Ticker, Long> {

    List<Ticker> findAll();
}

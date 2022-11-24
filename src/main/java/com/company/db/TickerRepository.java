package com.company.db;

import com.company.entity.Ticker;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TickerRepository extends CrudRepository<Ticker, Long> {

    List<Ticker> findAll();
}

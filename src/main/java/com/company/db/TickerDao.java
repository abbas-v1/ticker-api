/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.db;

import com.company.entity.Ticker;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 *
 * @author abbas
 */
@Repository
public class TickerDao {

    public void saveTickerData(List<List<Integer>> tickerData) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        for (List<Integer> list : tickerData) {
            session.beginTransaction();
            session.save(mapToTicker(list));
            session.getTransaction().commit();
        }

        session.close();
    }

    private Ticker mapToTicker(List<Integer> list) {
        Ticker ticker = new Ticker();
        ticker.setId(new Date().getTime());
        ticker.setChannelId(list.get(0));
        ticker.setBid(list.get(1));
        ticker.setBidSize(list.get(2));
        ticker.setAsk(list.get(3));
        ticker.setAskSize(list.get(4));
        ticker.setDailyChange(list.get(5));
        ticker.setDailyChangePerc(list.get(6));
        ticker.setLastPrice(list.get(7));
        ticker.setVolume(list.get(8));
        ticker.setHigh(list.get(9));
        ticker.setLow(list.get(10));
        return ticker;
    }

}

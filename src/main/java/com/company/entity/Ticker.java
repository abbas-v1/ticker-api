package com.company.entity;
// Generated Dec 31, 2018 4:23:12 PM by Hibernate Tools 4.3.1


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;

import java.io.Serializable;

/**
 * Ticker generated by hbm2java
 */
@Data
@Builder
public class Ticker implements Persistable<Long> {

    @Id
    private long id;
    private long channelId;
    private int bid;
    private int bidSize;
    private int ask;
    private int askSize;
    private int dailyChange;
    private int dailyChangePerc;
    private int lastPrice;
    private int volume;
    private int high;
    private int low;

    @Override
    public boolean isNew() {
        return true;
    }

    @Override
    public Long getId() {
        return this.id;
    }
}



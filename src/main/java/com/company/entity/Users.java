package com.company.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
public class Users implements Serializable {

    @Id
    private long userId;

    private String firstName;

    private String lastName;

    private Date registration;

}

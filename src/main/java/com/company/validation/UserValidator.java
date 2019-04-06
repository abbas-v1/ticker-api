/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.validation;

import com.company.dto.UserV1;

/**
 *
 * @author abbas
 */
public class UserValidator implements ValidatorBase<UserV1> {

    @Override
    public void isValid(UserV1 e) {
        System.out.println("Inside valiadtion");

        if (e.getFirstName().equals("Khan")) {
            throw new ValidationException("Not a good name");
        }
    }

}

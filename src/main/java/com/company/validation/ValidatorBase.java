/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.validation;

/**
 *
 * @author abbas
 * @param <E>
 */
public interface ValidatorBase<E> {
    
    void isValid(E e);
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.db;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory object.
 *
 * @author abbas
 */
public class HibernateUtil {

    private static final SessionFactory SESSION_FACTORY;
    private static final Logger LOG = LogManager.getLogger(HibernateUtil.class);
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) config file.
            SESSION_FACTORY = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            LOG.error("Initial SessionFactory creation failed.", ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }
}

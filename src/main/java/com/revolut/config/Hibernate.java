package com.revolut.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hibernate {

    private static SessionFactory sessionFactory;


    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {

            configure();
        }
        return sessionFactory;
    }

    private static void configure() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

}

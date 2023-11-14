package com.example.hibernate;

import io.javalin.plugin.hibernate.HibernatePlugin;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConfigHibernate implements HibernatePlugin.Config {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        }
        return sessionFactory;
    }

    @Override
    public SessionFactory sessionFactory() {
        return getSessionFactory();
    }

    public static void closeSessionFactory() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}

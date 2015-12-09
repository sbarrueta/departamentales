package com.tresct.departamentales.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
 
public class HibernateUtil {
 
    private static final SessionFactory SESSION_FACTORY;
 
    static {
        try {
            Configuration configuration = new Configuration().configure();
 
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();
 
            SESSION_FACTORY = configuration.buildSessionFactory(serviceRegistry);
        }
        catch (HibernateException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
     
    private HibernateUtil(){
    }
 
    public static SessionFactory getSessionfactory() {
        return SESSION_FACTORY;
    }
}
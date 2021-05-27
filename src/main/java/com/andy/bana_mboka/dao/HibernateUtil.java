package com.andy.bana_mboka.dao;

import static java.lang.System.err;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Ir Andy
 */


public class HibernateUtil {
   private static final SessionFactory sessionFactory;
    static{
        try{
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }catch(HibernateException ex){
            err.println("Erreur lors de l'initialisation " +ex.getMessage());
            throw new ExceptionInInitializerError(ex.getMessage());
        }
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    } 
}

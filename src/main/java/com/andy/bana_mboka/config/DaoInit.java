package com.andy.bana_mboka.config;

import com.andy.bana_mboka.dao.HibernateUtil;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.hibernate.Session;

/**
 *
 * @author Ir Andy
 */

@WebListener
public class DaoInit implements ServletContextListener{
    private Session session;
    public static final String ATT_DAO_FACTORY = "daofactory";
    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext servletContext = event.getServletContext();
        session = HibernateUtil.getSessionFactory().openSession();
        servletContext.setAttribute(ATT_DAO_FACTORY, session);
        System.out.println("Debut de test");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        session.close();
    }
}

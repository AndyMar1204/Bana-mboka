package com.andy.bana_mboka.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Ir Andy
 * @param <E> entite
 * @param <I> identifiant
 */
public class GenericDAO<E, I>  {

    private Session session;
    private Class<E> entity;

    public Session getSession() {
        return session;
    }

    public GenericDAO(Session session, Class<E> entity) {
        this.session = session;
        this.entity = entity;
    }

    
    public I save(E e) throws Exception{
        Transaction tx = null;
        I result;
        try {
            tx = session.beginTransaction();
            result = (I) session.save(e);
            tx.commit();
        } catch (Exception ex) {
            if (tx != null) {
                tx.rollback();
            }
            throw ex;
        }
        return result;
    }

   
    public void update(E e) throws Exception {
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.update(e);
            tx.commit();
        }catch(Exception ex){
            if(tx!=null)
                tx.rollback();
            throw ex;
        }
    }

    public void delete(E e)throws Exception {
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.delete(e);
            tx.commit();
        }catch(Exception ex){
            if(tx!=null)
                tx.rollback();
            throw ex;
        }
    }

   
    public E getById(long i) throws Exception{
        return session.get(entity, i);
    }

   
    public List<E> getAll() throws Exception{
        return (List<E>) session.createQuery("from " + entity.getName()).list();
    }

}

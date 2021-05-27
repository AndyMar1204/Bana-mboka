
package com.andy.bana_mboka.dao;


import com.andy.bana_mboka.model.User;
import org.hibernate.Criteria;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Ir Andy
 */


public class UserDao extends GenericDAO<User,Long>{
    
    public UserDao(Session session) {
        super(session, User.class);
    }
    public User connexion(String email, String password){
        User user;
        
            Session session = this.getSession();
            Criteria criteria = session.createCriteria(User.class);
            criteria = criteria.add(Restrictions.eq("email", email)).add(Restrictions.eq("password", password));
            user = (User) criteria.list().get(0);
          
            return user;
        
        
    }
}

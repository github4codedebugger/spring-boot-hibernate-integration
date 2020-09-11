package com.orm.repo;

import com.orm.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class UserRepo {

    @Autowired
    private SessionFactory sessionFactory;

    public User saveUser(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Integer id = (Integer) session.save(user);
        session.getTransaction().commit();
        user.setId(id);
        return user;
    }


    public List<User> findAll() {
        Session session =  sessionFactory.getCurrentSession();
        CriteriaQuery<User> query = session.getCriteriaBuilder().createQuery(User.class);
        query.from(User.class);
        List<User> users =  session.createQuery(query).getResultList();
        session.close();
        return users;
    }
}

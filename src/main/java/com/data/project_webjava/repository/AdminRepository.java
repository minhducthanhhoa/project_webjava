package com.data.project_webjava.repository;

import com.data.project_webjava.entity.Admin;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public Admin findByUsernameAndPassword(String username, String password) {
        Session session = sessionFactory.openSession();
        try {
            Query<Admin> query = session.createQuery("FROM Admin WHERE username = :u AND password = :p", Admin.class);
            query.setParameter("u", username);
            query.setParameter("p", password);
            return query.uniqueResult();
        } finally {
            session.close();
        }
    }
}

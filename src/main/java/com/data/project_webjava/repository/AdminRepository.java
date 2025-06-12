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
            return (Admin) session.createQuery("from Admin a where a.username = :u and a.password = :p").setParameter("u",username).setParameter("p",password).getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
            return null ;
        }
    }
}

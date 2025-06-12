package com.data.project_webjava.repository;

import com.data.project_webjava.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class BookRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Book> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Book", Book.class).list();
        }
    }

    public void save(Book book) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(book);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e;
        }
    }

    public long count() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT count(b) FROM Book b", Long.class).uniqueResult();
        }
    }

    public boolean existsByCode(String code) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "SELECT count(b) FROM Book b WHERE b.code = :code";
            Long count = session.createQuery(hql, Long.class)
                    .setParameter("code", code)
                    .uniqueResult();
            return count > 0;
        }
    }

    public boolean existsByTitle(String title) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "SELECT count(b) FROM Book b WHERE b.title = :title";
            Long count = session.createQuery(hql, Long.class)
                    .setParameter("title", title)
                    .uniqueResult();
            return count > 0;
        }
    }
}

package ru.geekbrains.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.geekbrains.HibernateSessionFactoryUtil;
import ru.geekbrains.dao.ProductDao;
import ru.geekbrains.entity.Product;
import java.util.List;

public class ProductManager implements ProductDao {
    @Override
    public List<Product> findAll() {
        List<Product> products = (List<Product>) HibernateSessionFactoryUtil.getSessionFactory().openSession()
                .createQuery("From Product").list();
        return products;
    }

    @Override
    public void save(Product product) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(product);
        tx1.commit();
        session.close();
    }

    @Override
    public Product findById(Long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Product.class, id);
    }

    @Override
    public void update(Product product) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(product);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Product product) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(product);
        tx1.commit();
        session.close();
    }
}

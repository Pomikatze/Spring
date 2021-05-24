package ru.geekbrains.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import ru.geekbrains.HibernateSessionFactoryUtil;
import ru.geekbrains.dao.PersonDao;
import ru.geekbrains.entity.Person;
import java.util.List;

@Component
public class PersonManager implements PersonDao {
    @Override
    public List<Person> findAll() {
        List<Person> persons = (List<Person>) HibernateSessionFactoryUtil.getSessionFactory().openSession()
                .createQuery("From Person").list();
        return persons;
    }

    @Override
    public void save(Person person) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(person);
        tx1.commit();
        session.close();
    }

    @Override
    public Person findById(Long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Person.class, id);
    }

    @Override
    public void update(Person person) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(person);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Person person) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(person);
        tx1.commit();
        session.close();
    }
}

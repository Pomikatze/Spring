package ru.geekbrains.dao;

import org.springframework.stereotype.Component;
import ru.geekbrains.entity.Person;

import java.util.List;

@Component
public interface PersonDao {
    List<Person> findAll();
    void save (Person person);
    Person findById (Long id);
    void update (Person person);
    void delete (Person person);
}

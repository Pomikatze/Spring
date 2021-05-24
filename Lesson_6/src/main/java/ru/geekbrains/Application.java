package ru.geekbrains;

import ru.geekbrains.entity.Person;
import ru.geekbrains.entity.Product;
import ru.geekbrains.service.PersonManager;
import ru.geekbrains.service.ProductManager;

import java.sql.SQLException;
import java.util.List;


public class Application {
    public static void main(String[] args) throws SQLException {
        PersonManager personManager = new PersonManager();
        Person person1 = personManager.findById(3L);
        List<Product> list = person1.getProduct_id();
        list.stream().forEach(System.out::println);
    }
}

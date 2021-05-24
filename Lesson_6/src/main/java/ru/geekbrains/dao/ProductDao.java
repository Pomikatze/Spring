package ru.geekbrains.dao;

import org.springframework.stereotype.Component;
import ru.geekbrains.entity.Product;

import java.util.List;

@Component
public interface ProductDao {
    List<Product> findAll();
    void save (Product product);
    Product findById (Long id);
    void update (Product product);
    void delete (Product product);
}

package com.geekbrains.Lesson_7.repo;

import com.geekbrains.Lesson_7.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}

package com.geekbrains.Lesson_7.controller;

import com.geekbrains.Lesson_7.entity.Product;
import com.geekbrains.Lesson_7.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public String findAllProducts(Model model) {
        List<Product> productList = productRepository.findAll();
        model.addAttribute("products", productList);
        return "index";
    }

    @PostMapping("{id}")
    public String deleteProduct(@PathVariable Long id){
        productRepository.deleteById(id);
        return "index";
    }
}

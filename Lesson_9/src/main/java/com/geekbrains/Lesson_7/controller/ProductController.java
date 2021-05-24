package com.geekbrains.Lesson_7.controller;

import com.geekbrains.Lesson_7.entity.Product;
import com.geekbrains.Lesson_7.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("{id}")
    public Product findById (@RequestParam Long id){
        return productRepository.findById(id).get();
    }

    @PostMapping
    public Product saveProduct (@RequestBody Product product){
        productRepository.save(product);
        return product;
    }

    @PutMapping
    public void updateProduct (@RequestBody Product product){
        productRepository.save(product);
    }

    @DeleteMapping("{id}")
    public int deleteProduct(@PathVariable Long id){
        productRepository.deleteById(id);
        return HttpStatus.OK.value();
    }
}

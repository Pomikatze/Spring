package com.geekbrains.Lesson_7.controller;

import com.geekbrains.Lesson_7.entity.Product;
import com.geekbrains.Lesson_7.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class ProductController {
    private ProductRepo productRepo;

    @Autowired
    public ProductController(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @GetMapping ("/products/")
    public List<Product> productAll (){
        return productRepo.findAll();
    }

    @GetMapping ("/products/delete/{id}")
    public String deleteProductById(@PathVariable Long id, HttpServletResponse response) {
        productRepo.deleteById(id);
        return "redirect:/products";
    }

    @PostMapping ("/products/")
    public String saveProduct (Product product, HttpServletResponse response){
        productRepo.save(product);
        return "redirect:/products";
    }

    @GetMapping("/products/{id}")
    public Product getById (@PathVariable Long id){
        return productRepo.findById(id).get();
    }
}

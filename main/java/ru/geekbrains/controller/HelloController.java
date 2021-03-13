package ru.geekbrains.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.geekbrains.Product;

import java.awt.*;

@Controller
public class HelloController {
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("message", "Hello, World!");
        return "index";
    }

    @GetMapping(value = "/json/get", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getJasonProduct() {
        Product product = new Product("Jacket", 1000);
        return String.format("{\"product\": {\"name\": \"%s\", \"price\": \"%s\"}}",
                product.getName(), product.getPrice());
    }

    @GetMapping(value = "/xml/get", produces = MediaType.APPLICATION_XML_VALUE)
    public String getXml(){
        Product product = new Product("Jacket", 1000);
        return String.format("<product>" +
                    "<name>%s</name>" +
                    "<price>%s</price>" +
                "</product>", product.getName(), product.getPrice());
    }
}

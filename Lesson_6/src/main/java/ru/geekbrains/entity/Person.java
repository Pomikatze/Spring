package ru.geekbrains.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable (name = "product", joinColumns = @JoinColumn (name = "person_id"),
    inverseJoinColumns = @JoinColumn (name = "product_id"))
    private List<Product> product_id;

    public Person() {
    }

    public List<Product> getProduct_id() {
        return product_id;
    }

    public void setProduct_id(List<Product> product_id) {
        this.product_id = product_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
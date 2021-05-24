package ru.geekbrains.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price", nullable = false)
    private Long price;

    @ManyToMany
    @JoinTable (name = "person", joinColumns = @JoinColumn (name = "product_id"),
    inverseJoinColumns = @JoinColumn (name = "person_id"))
    private List<Person> person_id;

    public Product() {
    }

    public List<Person> getPerson_id() {
        return person_id;
    }

    public void setPerson(List<Person> person_id) {
        this.person_id = person_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}

package com.example.crud2spb;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    private Long id_product;
    private String name_product;
    private Double price;
    private Long categoria_id;

     // Getters
     public Long getId_product() {
        return id_product;
    }

    public String getName_product() {
        return name_product;
    }

    public Double getPrice() {
        return price;
    }

    public Long getCategoria_id() {
        return categoria_id;
    }

    // Setters
    public void setId_product(Long id_product) {
        this.id_product = id_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setCategoria_id(Long categoria_id) {
        this.categoria_id = categoria_id;
    }
}

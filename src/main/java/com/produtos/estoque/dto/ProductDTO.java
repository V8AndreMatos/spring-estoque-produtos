package com.produtos.estoque.dto;

import com.produtos.estoque.entities.Product;

import java.util.UUID;

public class ProductDTO {

    private UUID id;
    private String name;
    private Double price;
    private Integer quantity;

    public ProductDTO(Product entity){
        id =entity.getId();
        name = entity.getName();
        price = entity.getPrice();
        quantity = entity.getQuantity();
    }

    public ProductDTO(UUID id, String name, Double price, Integer quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

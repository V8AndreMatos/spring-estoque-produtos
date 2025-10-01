package com.produtos.estoque.repositories;


import com.produtos.estoque.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

    public interface ProductRepository extends JpaRepository<Product, UUID> {

        

    }

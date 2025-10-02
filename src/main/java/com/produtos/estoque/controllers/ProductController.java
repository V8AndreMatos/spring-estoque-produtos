package com.produtos.estoque.controllers;

import com.produtos.estoque.dto.ProductDTO;
import com.produtos.estoque.entities.Product;
import com.produtos.estoque.repositories.ProductRepository;
import com.produtos.estoque.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public Page<ProductDTO> findAll(Pageable pageable) {
        PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort());
        return productService.findAllPaged(pageable);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> findById(UUID id){

        ProductDTO productDTO = productService.findById(id);
        return ResponseEntity.ok().body(productDTO);
    }

    public ResponseEntity<String> deleteById(@PathVariable UUID id){

        productService.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Id " +id+ " deletado com sucesso");

    }


    }


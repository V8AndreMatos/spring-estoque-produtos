package com.produtos.estoque.services;

import com.produtos.estoque.dto.ProductDTO;
import com.produtos.estoque.entities.Product;
import com.produtos.estoque.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Page<ProductDTO> findAllPaged(Pageable pageable) {
        Page<Product> listProduct = productRepository.findAll(pageable);
        return listProduct.map(ProductDTO::new);
    }



    public ProductDTO findById(UUID id){

        return productRepository.findById(id).map(x -> new ProductDTO(x.getId(), x.getName(), x.getPrice(), x.getQuantity()))
                .orElseThrow(() -> new RuntimeException("Id Not Found" + id));
    }

}

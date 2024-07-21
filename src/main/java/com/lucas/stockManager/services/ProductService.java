package com.lucas.stockManager.services;

import com.lucas.stockManager.dtos.ProductResponseDTO;
import com.lucas.stockManager.models.ProductModel;
import com.lucas.stockManager.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
        List<ProductModel> products = productRepository.findAll();
        List<ProductResponseDTO> productResponseDTOS = new ArrayList<>();
        for (ProductModel product : products) {
            productResponseDTOS.add(new ProductResponseDTO(product));
        }
        return ResponseEntity.ok(productResponseDTOS);
    }
}

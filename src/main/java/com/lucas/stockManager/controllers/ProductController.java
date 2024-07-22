package com.lucas.stockManager.controllers;

import com.lucas.stockManager.dtos.ProductRequestDTO;
import com.lucas.stockManager.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(("/api/products"))
public class ProductController {

    private final ProductService productService;
    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public <T> ResponseEntity<?> getAllProducts() {
        return productService.getAllProducts();
    }
}

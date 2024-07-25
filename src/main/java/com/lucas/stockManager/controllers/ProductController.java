package com.lucas.stockManager.controllers;

import com.lucas.stockManager.dtos.ProductRequestDTO;
import com.lucas.stockManager.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping(("/api/products"))
public class ProductController {

    private final ProductService productService;
    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<?> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public ResponseEntity<?> saveProduct(@RequestBody ProductRequestDTO productData) {
        return productService.saveProduct(productData);
    }

    @DeleteMapping(path = "/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable BigInteger productId) {
        return productService.deleteProduct(productId);
    }

    @PutMapping(path = "/{productId}")
    public ResponseEntity<?> updateProduct(@PathVariable BigInteger productId, @RequestBody ProductRequestDTO productData) {
        return productService.updateProduct(productId, productData);
    }
}

package com.lucas.stockManager.controllers;

import com.lucas.stockManager.services.ProductStockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/productStock")
public class ProductStockController {
    private final ProductStockService productStockService;
    public ProductStockController(ProductStockService productStockService) {
        this.productStockService = productStockService;
    }

    @GetMapping
    public ResponseEntity<?> getAllProductStock() {
        return productStockService.getAllProductStocks();
    }
}

package com.lucas.stockManager.controllers;

import com.lucas.stockManager.dtos.StockRequestDTO;
import com.lucas.stockManager.services.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("/api/stocks")
public class StockController {
    private final StockService stockService;
    public StockController(StockService stockService) { this.stockService = stockService; }

    @GetMapping
    public ResponseEntity<?> getAllStocks() {
        return stockService.getAllStocks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStockById(@PathVariable BigInteger id) {
        return stockService.getStockById(id);
    }

    @PostMapping
    public ResponseEntity<?> saveStock(@RequestBody StockRequestDTO stockData) {
        return stockService.saveStock(stockData);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStock(@RequestBody StockRequestDTO stockData, @PathVariable BigInteger id) {
        return stockService.updateStock(stockData, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStock(@PathVariable BigInteger id) {
        return stockService.deleteStock(id);
    }
}

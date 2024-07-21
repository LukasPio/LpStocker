package com.lucas.stockManager.dtos;

import com.lucas.stockManager.models.ProductModel;
import java.math.BigDecimal;

public record ProductResponseDTO(String name, BigDecimal price, String description, String productCategory) {
    public ProductResponseDTO(ProductModel productModel) {
        this(productModel.getName(), productModel.getPrice(), productModel.getDescription(), String.valueOf(productModel.getCategory()));
    }
}

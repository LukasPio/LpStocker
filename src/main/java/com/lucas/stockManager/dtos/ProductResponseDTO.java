package com.lucas.stockManager.dtos;

import com.lucas.stockManager.models.ProductModel;
import java.math.BigDecimal;
import java.math.BigInteger;

public record ProductResponseDTO(String name, BigDecimal price, String description, String category, BigInteger id) {
    public ProductResponseDTO(ProductModel productModel) {
        this(
                productModel.getName(),
                productModel.getPrice(),
                productModel.getDescription(),
                String.valueOf(productModel.getCategory()),
                productModel.getId()
        );
    }
}

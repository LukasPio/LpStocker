package com.lucas.stockManager.dtos;

import com.lucas.stockManager.models.ProductModel;
import com.lucas.stockManager.models.ProductStockModel;
import com.lucas.stockManager.models.StockModel;

public record ProductStockResponseDTO(ProductModel product, StockModel stockModel, Integer quantity) {
    public ProductStockResponseDTO(ProductStockModel productStockModel) {
        this(productStockModel.getProduct(), productStockModel.getStock(), productStockModel.getQuantity());
    }
}

package com.lucas.stockManager.dtos;

import com.lucas.stockManager.enums.ProductCategory;

import java.math.BigDecimal;

public record ProductRequestDTO(String name, BigDecimal price, String description, String category) {
    public boolean isAnyCampNull() {
        return name == null || price == null || description == null || category == null;
    }
    public boolean isValidCategory() {
            for (ProductCategory aCategory : ProductCategory.values()) {
                if (aCategory.getCategory().equalsIgnoreCase(this.category)) {
                    return true;
                }
            }
            return false;
    }
}

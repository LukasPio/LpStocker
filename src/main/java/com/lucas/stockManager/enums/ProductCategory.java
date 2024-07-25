package com.lucas.stockManager.enums;

import lombok.Getter;

@Getter
public enum ProductCategory {
    ELECTRONICS("Electronics"),
    BOOKS("Books"),
    CLOTHING("Clothing"),
    TOYS("Toys"),
    OTHER("Other");

    private final String category;

    ProductCategory(String category) {
        this.category = category;
    }
}

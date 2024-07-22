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

    public static boolean isValidCategory(String category) {
        for (ProductCategory c : ProductCategory.values()) {
            if (c.getCategory().equalsIgnoreCase(category)) {
                return true;
            }
        }
        return false;
    }
}

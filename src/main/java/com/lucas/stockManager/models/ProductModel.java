package com.lucas.stockManager.models;

import com.lucas.stockManager.dtos.ProductRequestDTO;
import com.lucas.stockManager.enums.ProductCategory;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private String name;
    private String description;
    private BigDecimal price;
    private String category;

    public ProductModel(ProductRequestDTO productData) {
        this.name = productData.name();
        this.description = productData.description();
        this.price = productData.price();
        this.category = productData.category();
    }
}


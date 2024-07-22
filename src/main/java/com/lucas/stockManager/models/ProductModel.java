package com.lucas.stockManager.models;

import com.lucas.stockManager.dtos.ProductRequestDTO;
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
    @Column(name = "product_id")
    private BigInteger id;
    @Column(name = "product_name")
    private String name;
    @Column(name = "product_description")
    private String description;
    @Column(name = "product_price")
    private BigDecimal price;
    @Column(name = "product_category")
    private String category;

    public ProductModel(ProductRequestDTO productData) {
        this.name = productData.name();
        this.description = productData.description();
        this.price = productData.price();
        this.category = productData.category();
    }
}


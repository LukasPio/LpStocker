package com.lucas.stockManager.model;

import com.lucas.stockManager.helpers.ProductStockId;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigInteger;

@Entity
public class ProductStock {
    @EmbeddedId
    private ProductStockId id;

    @ManyToOne
    @MapsId("product_id")
    @JoinColumn(name = "stock_id")
    private ProductModel product;

    @ManyToOne
    @MapsId("stockId")
    @JoinColumn(name = "stock_id")
    private StockModel stock;

    @Column(nullable = false)
    private Integer quantity;


}

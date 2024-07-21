package com.lucas.stockManager.models;

import com.lucas.stockManager.helpers.ProductStockId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ProductStock {
    @EmbeddedId
    private ProductStockId id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private ProductModel product;

    @ManyToOne
    @MapsId("stockId")
    @JoinColumn(name = "stock_id")
    private StockModel stock;

    @Column(nullable = false)
    private Integer quantity;
}

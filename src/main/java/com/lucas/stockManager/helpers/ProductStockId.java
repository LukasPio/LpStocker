package com.lucas.stockManager.helpers;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ProductStockId implements Serializable  {
        private Long productId;
        private Long stockId;
}

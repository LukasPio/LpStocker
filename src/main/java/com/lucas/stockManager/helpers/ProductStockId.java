package com.lucas.stockManager.helpers;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ProductStockId implements Serializable  {
        private Long productId;
        private Long stockId;
}

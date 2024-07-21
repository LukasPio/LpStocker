package com.lucas.stockManager.helpers;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ProductStockId implements Serializable  {
        private Long productId;
        private Long stockId;

    @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                ProductStockId that = (ProductStockId) o;
                return Objects.equals(productId, that.productId) && Objects.equals(stockId, that.stockId);
        }

        @Override
        public int hashCode() {
                return Objects.hash(productId, stockId);
        }
}

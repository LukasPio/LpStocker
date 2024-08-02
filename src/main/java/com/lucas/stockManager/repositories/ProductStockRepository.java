package com.lucas.stockManager.repositories;

import com.lucas.stockManager.models.ProductStockModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface ProductStockRepository extends JpaRepository<ProductStockModel, BigInteger> {
}

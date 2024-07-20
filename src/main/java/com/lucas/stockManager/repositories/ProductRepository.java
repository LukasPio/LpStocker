package com.lucas.stockManager.repositories;

import com.lucas.stockManager.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface ProductRepository extends JpaRepository<ProductModel, BigInteger> {
}

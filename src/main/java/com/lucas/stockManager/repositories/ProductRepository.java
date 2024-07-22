package com.lucas.stockManager.repositories;

import com.lucas.stockManager.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, BigInteger> {
    boolean existsByName(String name);
}

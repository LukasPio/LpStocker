package com.lucas.stockManager.repositories;

import com.lucas.stockManager.models.StockModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface StockRepository extends JpaRepository<StockModel, BigInteger> {
}

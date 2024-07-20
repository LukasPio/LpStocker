package com.lucas.stockManager.repositories;

import com.lucas.stockManager.models.StockModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface StockRepository extends JpaRepository<StockModel, BigInteger> {
}

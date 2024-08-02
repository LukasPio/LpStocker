package com.lucas.stockManager.models;

import com.lucas.stockManager.dtos.StockRequestDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Entity
@Table(name = "stock")
@Getter
@Setter
@NoArgsConstructor
public class StockModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_id")
    private BigInteger id;

    @Column(name = "stock_name")
    private String name;

    @Column(name = "stock_totalCapacity")
    private BigInteger totalCapacity;

    @Column(name = "stock_currentOccupation", nullable = false)  // Ensure this matches the column name in the DB
    private BigInteger currentOccupation;

    public StockModel(StockRequestDTO stockData) {
        this.name = stockData.name();
        this.totalCapacity = stockData.totalCapacity();
        this.currentOccupation = stockData.currentOccupation();
    }
}

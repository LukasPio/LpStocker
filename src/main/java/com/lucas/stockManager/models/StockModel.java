package com.lucas.stockManager.models;

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
    @Column(name = "stock_totalcapacity")
    private BigInteger totalCapacity;
    @Column(name = "stock_currentOccupation")
    private BigInteger currentOccupation;
}

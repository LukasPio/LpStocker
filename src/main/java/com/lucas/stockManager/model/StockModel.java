package com.lucas.stockManager.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Entity
@Table
@Getter
@Setter
public class StockModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private String name;
    private BigInteger totalCapacity;
    private BigInteger currentOccupation;
}

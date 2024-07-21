package com.lucas.stockManager.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Entity
@Table(name = "stock")
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

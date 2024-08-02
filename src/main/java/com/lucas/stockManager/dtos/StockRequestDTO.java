package com.lucas.stockManager.dtos;

import java.math.BigInteger;

public record StockRequestDTO(String name, BigInteger totalCapacity, BigInteger currentOccupation) {
    public boolean isAnyCampNull() {
        return name == null || totalCapacity == null || currentOccupation == null;
    }
}

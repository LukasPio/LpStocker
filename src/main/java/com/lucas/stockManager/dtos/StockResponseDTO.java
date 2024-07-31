package com.lucas.stockManager.dtos;

import com.lucas.stockManager.models.StockModel;

import java.math.BigInteger;

public record StockResponseDTO(BigInteger id, String name, BigInteger totalCapacity, BigInteger currentOccupation) {
    public StockResponseDTO(StockModel stockModel) {
        this(stockModel.getId(), stockModel.getName(), stockModel.getTotalCapacity(), stockModel.getCurrentOccupation());
    }
}

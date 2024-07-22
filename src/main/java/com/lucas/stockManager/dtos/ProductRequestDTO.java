package com.lucas.stockManager.dtos;

import java.math.BigDecimal;

public record ProductRequestDTO(String name, BigDecimal price, String description, String category) {
}

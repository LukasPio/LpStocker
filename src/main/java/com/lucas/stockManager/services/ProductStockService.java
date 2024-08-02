package com.lucas.stockManager.services;

import com.lucas.stockManager.dtos.ProductStockResponseDTO;
import com.lucas.stockManager.models.ProductStockModel;
import com.lucas.stockManager.repositories.ProductStockRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductStockService {
    private final ResponseService responseService;
    private final ProductStockRepository productStockRepository;
    public ProductStockService(ProductStockRepository productStockRepository, ResponseService responseService) {
        this.productStockRepository = productStockRepository;
        this.responseService = responseService;
    }

    public ResponseEntity<?> getAllProductStocks() {
        List<ProductStockModel> productStocksList = productStockRepository.findAll();
        if (productStocksList.isEmpty()) return responseService.buildResponse(
                HttpStatus.NO_CONTENT.value(),
                "There aren't saved productStock association",
                ' '
        );
        List<ProductStockResponseDTO> productStocksResponse = productStocksList.stream().map(ProductStockResponseDTO::new).toList();
        return responseService.buildResponse(
                HttpStatus.OK.value(),
                "Get all productStock associations successfully",
                productStocksResponse
        );
    }
}

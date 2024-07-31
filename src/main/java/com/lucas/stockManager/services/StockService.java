package com.lucas.stockManager.services;

import com.lucas.stockManager.dtos.StockResponseDTO;
import com.lucas.stockManager.models.StockModel;
import com.lucas.stockManager.repositories.StockRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    private final StockRepository stockRepository;
    private final ResponseService responseService;
    public StockService(StockRepository stockRepository, ResponseService responseService) {
        this.stockRepository = stockRepository;
        this.responseService = responseService;
    }

    public ResponseEntity<?> getAllStocks() {
        List<StockModel> stocks = stockRepository.findAll();
        if (stocks.isEmpty()) return responseService.buildResponse(
                    HttpStatus.NOT_FOUND.value(),
                    "There aren't saved stocks",
                    ""
            );
        List<StockResponseDTO> stockResponseDTOs = stocks.stream().map(StockResponseDTO::new).toList();
        return responseService.buildResponse(
                HttpStatus.OK.value(),
                "Get all stocks successfully",
                stockResponseDTOs
        );
    }
}

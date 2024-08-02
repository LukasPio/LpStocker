package com.lucas.stockManager.services;

import com.lucas.stockManager.dtos.StockRequestDTO;
import com.lucas.stockManager.dtos.StockResponseDTO;
import com.lucas.stockManager.models.StockModel;
import com.lucas.stockManager.repositories.StockRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
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
                    HttpStatus.NO_CONTENT.value(),
                    "There aren't saved stocks",
                    ' '
            );
        List<StockResponseDTO> stockResponseDTOs = stocks.stream().map(StockResponseDTO::new).toList();
        return responseService.buildResponse(
                HttpStatus.OK.value(),
                "Get all stocks successfully",
                stockResponseDTOs
        );
    }

    public ResponseEntity<?> getStockById(BigInteger id) {
        StockModel stock = stockRepository.findById(id).orElse(null);
        if (stock == null) return responseService.buildResponse(
                HttpStatus.BAD_REQUEST.value(),
                "There aren't any save stock with id: " + id,
                ' '
        );
        return responseService.buildResponse(
                HttpStatus.OK.value(),
                "Got stock with id " + id + " successfully",
                new StockResponseDTO(stock)
        );
    }

    public ResponseEntity<?> saveStock(StockRequestDTO stockData) {
        if (stockData.isAnyCampNull()) return responseService.buildResponse(
                    HttpStatus.BAD_REQUEST.value(),
                    "Any camp can be null",
                    ' '
            );
        StockModel stock = new StockModel(stockData);
        stockRepository.save(stock);
        return responseService.buildResponse(
                HttpStatus.OK.value(),
                "Stock was saved successfully",
                stockData
        );
    }
}

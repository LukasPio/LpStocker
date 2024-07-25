package com.lucas.stockManager.services;

import com.lucas.stockManager.dtos.ProductRequestDTO;
import com.lucas.stockManager.dtos.ProductResponseDTO;
import com.lucas.stockManager.enums.ProductCategory;
import com.lucas.stockManager.models.ProductModel;
import com.lucas.stockManager.repositories.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ResponseService responseService;
    ProductService(ProductRepository productRepository, ResponseService responseService) {
        this.productRepository = productRepository;
        this.responseService = responseService;
    }

    public ResponseEntity<?> getAllProducts() {
        List<ProductModel> products = productRepository.findAll();
        if (products.isEmpty()) {
            return responseService.buildResponse(
                    204,
                    "There aren't any saved products in database.",
                    null
            );
        }
        List<ProductResponseDTO> productResponseDTOS = products.stream().map(ProductResponseDTO::new).toList();
        return responseService.buildResponse(
                200,
                "Get all products successfully",
                productResponseDTOS
        );
    }

    public ResponseEntity<?> saveProduct(ProductRequestDTO productData) {
        if (productData == null) return responseService.buildResponse(
                    HttpStatus.BAD_REQUEST.value(),
                    "Any field of productRequest can be null.",
                    null);

        if (!ProductCategory.isValidCategory(productData.category())) return responseService.buildResponse(
                    HttpStatus.BAD_REQUEST.value(),
                    "The category entered is invalid.",
                    null);

        if (productRepository.existsByName(productData.name()))
            return responseService.buildResponse(
                    HttpStatus.CONFLICT.value(),
                    "Already exists a product with that name.",
                    null);

        ProductModel toSave = new ProductModel(productData);
        productRepository.save(toSave);

        return responseService.buildResponse(
                HttpStatus.CREATED.value(),
                "Product was saved succesfully.",
                toSave
        );
    }
}

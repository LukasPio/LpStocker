package com.lucas.stockManager.services;

import com.lucas.stockManager.helpers.ResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ResponseService {
    public <T> ResponseEntity<?> buildResponse(int code, String message, T body) {
        ResponseWrapper<T> responseWrapper = new ResponseWrapper<>(code, message, body);
        return new ResponseEntity<>(responseWrapper, HttpStatus.valueOf(code));
    }
}

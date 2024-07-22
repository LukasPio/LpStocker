package com.lucas.stockManager.helpers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ResponseWrapper <T> {
    private int code;
    private String message;
    private T body;
}

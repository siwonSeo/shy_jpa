package com.kakaopay.shy.common;

import com.kakaopay.shy.code.ErrorCode;

import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {
    private ErrorCode error;

    public ApiException(ErrorCode e) {
        super(e.getMessage());
        this.error = e;
    }
}

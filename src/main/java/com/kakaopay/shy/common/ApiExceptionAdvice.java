package com.kakaopay.shy.common;

import java.nio.file.AccessDeniedException;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.apache.bcel.ExceptionConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.kakaopay.shy.code.ErrorCode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ApiExceptionAdvice {
    @ExceptionHandler({ApiException.class})
    public ResponseEntity<ApiExceptionEntity> exceptionHandler(HttpServletRequest request, final ApiException e) {
        log.error("{}:{}", e.getError().getCode(),e.getError().getMessage());
        return ResponseEntity
                .status(e.getError().getHttpStatus())
                .body(ApiExceptionEntity.builder()
                        .errorCode(e.getError().getCode())
                        .errorMessage(e.getError().getMessage())
                        .build());
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<ApiExceptionEntity> exceptionHandler(HttpServletRequest request, final RuntimeException e) {
    	log.error("{}", e.getMessage());
        return ResponseEntity
                .status(ErrorCode.API_UNKNOWN_ERROR.getHttpStatus())
                .body(ApiExceptionEntity.builder()
                        .errorCode(ErrorCode.API_UNKNOWN_ERROR.getCode())
                        .errorMessage(ErrorCode.API_UNKNOWN_ERROR.getMessage())
                        .build());
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ApiExceptionEntity> exceptionHandler(HttpServletRequest request, final Exception e) {
    	log.error("{}", e.getMessage());
        return ResponseEntity
                .status(ErrorCode.API_UNKNOWN_ERROR.getHttpStatus())
                .body(ApiExceptionEntity.builder()
                        .errorCode(ErrorCode.API_UNKNOWN_ERROR.getCode())
                        .errorMessage(ErrorCode.API_UNKNOWN_ERROR.getMessage())
                        .build());
    }
}
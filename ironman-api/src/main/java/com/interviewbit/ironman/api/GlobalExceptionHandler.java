package com.interviewbit.ironman.api;

import com.interviewbit.ironman.common.exceptions.IronmanRuntimeException;
import com.interviewbit.ironman.dtos.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.ValidationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);



    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponseDto> handleIllegalArgumentException(IllegalArgumentException ex) {
        logger.error("IllegalArgumentException", ex);
        ErrorResponseDto errorResponseDto = new ErrorResponseDto("ILLIGAL ARGUMENTS", ex.getMessage());
        return new ResponseEntity<>(errorResponseDto, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({IronmanRuntimeException.class})
    public ResponseEntity<?> handleException(IronmanRuntimeException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.toError());
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorResponseDto> handleValidationException(ValidationException ex) {
        logger.error("Validation Error occured", ex);
        ErrorResponseDto errorResponseDto = new ErrorResponseDto("PARAM INVALID", ex.getMessage());
        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }
}

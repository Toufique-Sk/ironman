package com.interviewbit.ironman.common.exceptions;

import com.interviewbit.ironman.dtos.ErrorResponseDto;

public class IronmanRuntmeException extends RuntimeException {

    private String errorCode;
    private String errorMessage;

    public IronmanRuntmeException(String errorCode, String errorMessage){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public ErrorResponseDto toError(){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(errorCode, errorMessage);
        return errorResponseDto;
    }
}

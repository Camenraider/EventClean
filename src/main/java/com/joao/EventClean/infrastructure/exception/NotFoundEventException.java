package com.joao.EventClean.infrastructure.exception;

public class NotFoundEventException extends RuntimeException{

    public NotFoundEventException(String msm) {
        super(msm);
    }
    
}

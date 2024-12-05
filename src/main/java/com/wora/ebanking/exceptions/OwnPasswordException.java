package com.wora.ebanking.exceptions;

public class OwnPasswordException extends RuntimeException {
    public OwnPasswordException(String message) {
        super(message);
    }
}

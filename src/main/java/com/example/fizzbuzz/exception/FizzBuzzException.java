package com.example.fizzbuzz.exception;

// I follow the current convenient trend to extend RuntimeException, as it doesn't require a try catch block.
public class FizzBuzzException extends RuntimeException {
    public FizzBuzzException(String message) {
        super(message);
    }
}

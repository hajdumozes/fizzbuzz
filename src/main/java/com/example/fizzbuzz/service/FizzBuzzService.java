package com.example.fizzbuzz.service;

import java.util.List;

// It's always a good idea to make the service an interface because of the rules of inheritance in java
public interface FizzBuzzService {
    List<String> getFizzBuzzSequence(int last);
}

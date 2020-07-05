package com.example.fizzbuzz.config;

import com.example.fizzbuzz.util.LeastCommonMultiple;
import lombok.Getter;

import java.math.BigInteger;

// I wanted both the name and the values to come from a variable to avoid future headaches, when changes are needed.
// Since I don't need to change the values right now, and there is no specification how should it be done in the future, I chose an enum for it.
// I'd personally make the values settable on the front-end, and the enum fields could get a setter as well, so it wouldn't require a big refactoring.

// I had to decide between flexibility and divisor rules, and I chose the former, because I found flexibility more valuable.
@Getter
public enum FizzBuzz {
    FIZZ("Fizz", 3),
    BUZZ("Buzz", 5),
    FIZZ_BUZZ(FIZZ.name.concat(BUZZ.name),
            LeastCommonMultiple.getLcmForFizzBuzz(
                    BigInteger.valueOf(FIZZ.value),
                    BigInteger.valueOf(BUZZ.value)
            ).intValue());

    private String name;
    private int value;

    FizzBuzz(String name, int value) {
        this.name = name;
        this.value = value;
    }
}

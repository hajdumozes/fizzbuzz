package com.example.fizzbuzz.util;

import com.example.fizzbuzz.exception.FizzBuzzException;

import java.math.BigInteger;

// It's a Util class, so I make it impossible to be extended
public final class LeastCommonMultiple {

    // There's no point in instantiation being a Util class, hence the private constructor.
    private LeastCommonMultiple() {}

    // Being a Util class, I declare all methods static, so it can be accessed without instantiation
    // Math-wise my implementation has more rules, than it should have, but at the same time it's for the app.
    // The naming allows a painless addition in the future, if I need a more precise method for Lcm
    public static BigInteger getLcmForFizzBuzz(BigInteger a, BigInteger b) {
        if (a.signum() < 1 || b.signum() < 1) {
            throw new FizzBuzzException("Both numbers must be positive");
        }
        BigInteger greatestCommonDivisor = a.gcd(b);
        BigInteger multiplication = a.multiply(b);
        return multiplication.divide(greatestCommonDivisor);
    }
}

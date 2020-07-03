package com.example.fizzbuzz.util;

import com.example.fizzbuzz.exception.FizzBuzzException;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class LeastCommonMultipleTest {

    @Test(expected = FizzBuzzException.class)
    public void GetLcmForFizzBuzz_TwoNegativeNumbersAsParam_ExceptionThrown() {
        int a = -2;
        int b = -5;
        LeastCommonMultiple.getLcmForFizzBuzz(BigInteger.valueOf(a), BigInteger.valueOf(b));
    }

    @Test(expected = FizzBuzzException.class)
    public void GetLcmForFizzBuzz_OneNegativeNumbersAsParam_ExceptionThrown() {
        int a = -2;
        int b = -12;
        LeastCommonMultiple.getLcmForFizzBuzz(BigInteger.valueOf(a), BigInteger.valueOf(b));
    }

    @Test(expected = FizzBuzzException.class)
    public void GetLcmForFizzBuzz_ZeroAsParam_ExceptionThrown() {
        int a = 0;
        int b = 40;
        LeastCommonMultiple.getLcmForFizzBuzz(BigInteger.valueOf(a), BigInteger.valueOf(b));
    }

    @Test
    public void GetLcmForFizzBuzz_PositiveNumbersAsParam_Calculated() {
        int a = 15;
        int b = 3;
        BigInteger lcm = LeastCommonMultiple.getLcmForFizzBuzz(BigInteger.valueOf(a), BigInteger.valueOf(b));
        Assert.assertEquals(15, lcm.intValue());
    }
}

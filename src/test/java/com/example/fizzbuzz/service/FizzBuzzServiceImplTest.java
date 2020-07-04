package com.example.fizzbuzz.service;

import com.example.fizzbuzz.config.FizzBuzz;
import com.example.fizzbuzz.exception.FizzBuzzException;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzServiceImplTest {
    // I use polymorphism
    private FizzBuzzService fizzBuzzService;

    @Before
    public void init() {
        fizzBuzzService = new FizzBuzzServiceImpl();
    }

    // I follow Roy Osherove's naming convention
    @Test(expected = FizzBuzzException.class)
    public void GetFizzBuzzSequence_NegativeNumberAsParam_ExceptionThrown() {
        fizzBuzzService.getFizzBuzzSequence(-4);
    }

    @Test(expected = FizzBuzzException.class)
    public void GetFizzBuzzSequence_ZeroAsParam_ExceptionThrown() {
        fizzBuzzService.getFizzBuzzSequence(0);
    }

    @Test
    public void GetFizzBuzzSequence_PositiveNumberAsParam_ReturnsFizzBuzzSequence() {
        // As far as I know the default sequence goes from 1 to 100, but it's easy to replace that way
        int numberToTest = 100;
        List<String> sequence = fizzBuzzService.getFizzBuzzSequence(numberToTest);
        assertEquals(numberToTest, sequence.size());

        int fizzAmount = (int) Math.floor(numberToTest / FizzBuzz.FIZZ.getValue());
        List<String> fizzList = sequence.stream()
                .filter(item -> item.contains(FizzBuzz.FIZZ.getName()))
                .collect(Collectors.toList());
        assertEquals(fizzAmount, fizzList.size());

        int buzzAmount = (int) Math.floor(numberToTest / FizzBuzz.BUZZ.getValue());
        List<String> buzzList = sequence.stream()
                .filter(item -> item.contains(FizzBuzz.BUZZ.getName()))
                .collect(Collectors.toList());
        assertEquals(buzzAmount, buzzList.size());

        int fizzBuzzAmount = (int) Math.floor(numberToTest / FizzBuzz.FIZZ_BUZZ.getValue());
        List<String> fizzBuzzList = sequence.stream()
                .filter(item -> item.equals(FizzBuzz.FIZZ_BUZZ.getName()))
                .collect(Collectors.toList());
        assertEquals(fizzBuzzAmount, fizzBuzzList.size());
    }
}

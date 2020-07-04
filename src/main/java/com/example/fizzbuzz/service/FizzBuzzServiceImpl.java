package com.example.fizzbuzz.service;

import com.example.fizzbuzz.config.FizzBuzz;
import com.example.fizzbuzz.exception.FizzBuzzException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FizzBuzzServiceImpl implements FizzBuzzService {

    @Override
    public List<String> getFizzBuzzSequence(int last) {
        if (last < 1) {
            throw new FizzBuzzException("The sequence length must be a positive number");
        }
        List<String> sequence = new ArrayList<>();
        for (int i = 1; i <= last; i++) {
            // I use String instead of StringBuilder, because I don't modify it in a loop, so memory is not an issue.
            // Hence the more readable wins for me, which is String.
            String item = "";
            if (i % FizzBuzz.FIZZ.getValue() == 0) {
                item += FizzBuzz.FIZZ.getName();
            }
            if (i % FizzBuzz.BUZZ.getValue() == 0) {
                item += (FizzBuzz.BUZZ.getName());
            }
            if (item.equals("")) {
                item = String.valueOf(i);
            }
            sequence.add(item);
        }
        return sequence;
    }
}

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
        checkSequenceLength(last);
        return getSequenceList(last);
    }

    private void checkSequenceLength(int last) {
        if (last < 1) {
            throw new FizzBuzzException("The sequence length must be a positive number");
        }
    }

    private List<String> getSequenceList(int last) {
        List<String> sequence = new ArrayList<>();
        for (int i = 1; i <= last; i++) {
            // I use String instead of StringBuilder, because I don't modify it in a loop, so memory is not an issue.
            // Hence the more readable wins for me, which is String.
            addItem(sequence, i);
        }
        return sequence;
    }

    private void addItem(List<String> sequence, int i) {
        String item = "";
        item = checkFizz(item, i);
        item = checkBuzz(item, i);
        item = getNormalString(item, i);
        sequence.add(item);
    }

    private String getNormalString(String item, int i) {
        if (item.equals("")) {
            item = String.valueOf(i);
        }
        return item;
    }

    private String checkBuzz(String item, int i) {
        if (i % FizzBuzz.BUZZ.getValue() == 0) {
            item += (FizzBuzz.BUZZ.getName());
        }
        return item;
    }

    private String checkFizz(String item, int i) {
        if (i % FizzBuzz.FIZZ.getValue() == 0) {
            item += FizzBuzz.FIZZ.getName();
        }
        return item;
    }
}

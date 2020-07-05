package com.example.fizzbuzz.controller;

import com.example.fizzbuzz.exception.FizzBuzzException;
import com.example.fizzbuzz.service.FizzBuzzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// RestController uses Jackson by default
@RestController
@RequestMapping("/")
public class FizzBuzzController {

    @Autowired
    private FizzBuzzService fizzBuzzService;

    @GetMapping("/fizzbuzz")
    public ResponseEntity<List<String>> getSequence(@RequestParam(value = "last") Integer last) {
        List<String> sequence = fizzBuzzService.getFizzBuzzSequence(last);
        return ResponseEntity.ok(sequence);
    }

    @ExceptionHandler({FizzBuzzException.class})
    public ResponseEntity error(FizzBuzzException ex) {
        return ResponseEntity.badRequest().build();
    }
}

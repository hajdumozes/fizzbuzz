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

    // I found RequestParam more logical, than PathParam. Especially, if it would get any more params in the future, like a given range
    @GetMapping("/fizzbuzz")
    public ResponseEntity<List<String>> getSequence(@RequestParam(value = "last") Integer last) {
        List<String> sequence = fizzBuzzService.getFizzBuzzSequence(last);
        return ResponseEntity.ok(sequence);
    }

    // There were no specifications, how the exceptions should be handled, and what params should I accept.
    // In the current form it's impossible to give a problematic number on the front-end, so I chose to give back a badRequest
    // I find it flexible enough in case there is a specification for it in the future, since the exception has the error message
    @ExceptionHandler({FizzBuzzException.class})
    public ResponseEntity error(FizzBuzzException ex) {
        return ResponseEntity.badRequest().build();
    }
}

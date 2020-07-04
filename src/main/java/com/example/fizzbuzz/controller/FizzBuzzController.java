package com.example.fizzbuzz.controller;

import com.example.fizzbuzz.exception.FizzBuzzException;
import com.example.fizzbuzz.service.FizzBuzzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FizzBuzzController {

    @Autowired
    private FizzBuzzService fizzBuzzService;

    @GetMapping("/fizzbuzz")
    public String getSequence(@RequestParam(value = "last") Integer last, Model model) {
        List<String> sequence = fizzBuzzService.getFizzBuzzSequence(last);
        model.addAttribute("sequence", sequence);
        return "index";
    }

    @ExceptionHandler({FizzBuzzException.class})
    public String error(FizzBuzzException ex, Model model) {
        model.addAttribute("error", ex.getMessage());
        return "index";
    }

}

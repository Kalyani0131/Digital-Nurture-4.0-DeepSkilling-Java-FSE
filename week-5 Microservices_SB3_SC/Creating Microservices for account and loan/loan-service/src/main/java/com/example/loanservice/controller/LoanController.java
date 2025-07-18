package com.example.loanservice.controller;

import com.example.loanservice.model.Loan;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @GetMapping("/{accountNumber}")
    public Loan getLoanDetails(@PathVariable("accountNumber") String accountNumber) {
        return new Loan(123456L, "Home Loan", 2500000.00);
    }
}

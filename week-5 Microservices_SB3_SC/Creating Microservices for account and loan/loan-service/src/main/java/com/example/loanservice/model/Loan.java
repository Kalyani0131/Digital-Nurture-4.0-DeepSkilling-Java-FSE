package com.example.loanservice.model;

public class Loan {
    private Long loanNumber;
    private String loanType;
    private Double loanAmount;

    public Loan(Long loanNumber, String loanType, Double loanAmount) {
        this.loanNumber = loanNumber;
        this.loanType = loanType;
        this.loanAmount = loanAmount;
    }

    // Add Getters and Setters
    public Long getLoanNumber() { return loanNumber; }
    public String getLoanType() { return loanType; }
    public Double getLoanAmount() { return loanAmount; }

    public void setLoanNumber(Long loanNumber) { this.loanNumber = loanNumber; }
    public void setLoanType(String loanType) { this.loanType = loanType; }
    public void setLoanAmount(Double loanAmount) { this.loanAmount = loanAmount; }
}

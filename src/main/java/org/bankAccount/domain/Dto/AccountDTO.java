package org.bankAccount.domain.Dto;

import org.bankAccount.domain.model.Transaction;

import java.util.List;

public class AccountDTO {

    private double balance;
    private List<Transaction> transactions;

    public AccountDTO(double balance) {
        this.balance = balance;
    }

    public AccountDTO(double balance, List<Transaction> transactions) {
        this.balance = balance;
        this.transactions = transactions;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}

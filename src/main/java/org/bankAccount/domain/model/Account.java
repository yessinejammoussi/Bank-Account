package org.bankAccount.domain.model;

import java.util.Collections;
import java.util.List;

public class Account {
    private Long idAccount;
    private double balance;
    private List<Transaction> transactions;

    public Account(Long idAccount, double balance, List<Transaction> transactions) {
        this.idAccount = idAccount;
        this.balance = balance;
        this.transactions = transactions;
    }

    public Account(double balance, List<Transaction> transactions) {
        this.balance = balance;
        this.transactions = transactions;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add(new Transaction(amount,this.idAccount));
        } else {
            throw new IllegalArgumentException("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add(new Transaction(-amount, this.idAccount));
        } else {
            throw new IllegalArgumentException("Your balance is insufficient");
        }
    }
}

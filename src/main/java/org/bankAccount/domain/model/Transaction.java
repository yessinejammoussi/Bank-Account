package org.bankAccount.domain.model;

import java.time.LocalDateTime;

public class Transaction {

    private int idTransaction;
    private LocalDateTime timestamp;

    private int idAccount;
    private double amount;

    public Transaction(double amount,int idTransaction, int idAccount) {
        this.idTransaction = idTransaction;
        this.timestamp = LocalDateTime.now();
        this.idAccount = idAccount;
        this.amount = amount;
    }
    public Transaction(double amount, int idAccount) {
        this.timestamp = LocalDateTime.now();
        this.idAccount = idAccount;
        this.amount = amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public double getAmount() {
        return amount;
    }
}

package org.bankAccount.domain.model;

import java.time.LocalDateTime;

public class Transaction {

    private Long idTransaction;
    private LocalDateTime timestamp;

    private Long idAccount;
    private double amount;

    public Transaction(double amount,Long idTransaction, Long idAccount) {
        this.idTransaction = idTransaction;
        this.timestamp = LocalDateTime.now();
        this.idAccount = idAccount;
        this.amount = amount;
    }
    public Transaction(double amount, Long idAccount) {
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

package org.bankAccount.domain.service;

import org.bankAccount.domain.model.Account;
import org.bankAccount.domain.model.Transaction;

import java.util.List;

public interface AccountService {

    void deposit(Account account, double amount);
    void withdraw(Account account, double amount);
    double checkBalance(Account account);
    List<Transaction> getTransactions(Account account);
}

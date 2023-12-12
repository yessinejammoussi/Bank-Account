package org.bankAccount.domain.service;

import org.bankAccount.domain.Dto.AccountDTO;
import org.bankAccount.domain.Dto.TransactionDTO;
import org.bankAccount.domain.model.Account;
import org.bankAccount.domain.model.Transaction;

import java.util.List;

public interface AccountService {

    void deposit(Account account, double amount);
    void withdraw(Account account, double amount);
    AccountDTO checkBalance(Long idAccount);
    List<TransactionDTO> getTransactions(Long idAccount);
}

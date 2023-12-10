package org.bankAccount.domain.service;

import org.bankAccount.adapter.infrastructure.persistence.AccountRepository;
import org.bankAccount.domain.model.Account;
import org.bankAccount.domain.model.Transaction;

import java.util.List;

public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void deposit(Account account, double amount) {
        account.deposit(amount);
        accountRepository.save(account);
    }

    @Override
    public void withdraw(Account account, double amount) {
        account.withdraw(amount);
        accountRepository.save(account);
    }

    @Override
    public double checkBalance(Account account) {
        return account.getBalance();
    }

    @Override
    public List<Transaction> getTransactions(Account account) {
        return account.getTransactions();
    }
}

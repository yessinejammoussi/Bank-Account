package org.bankAccount.adapter.controller;

import org.bankAccount.domain.Dto.AccountDTO;
import org.bankAccount.domain.Dto.TransactionDTO;
import org.bankAccount.domain.model.Account;
import org.bankAccount.domain.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    private final AccountService accountServiceAdapter;

    public AccountController(AccountService accountServiceAdapter) {
        this.accountServiceAdapter = accountServiceAdapter;
    }

    @PostMapping("/deposit")
    public void deposit(@RequestBody Account account, double amount) {
        accountServiceAdapter.deposit(account,amount);
    }

    @PostMapping("/withdraw")
    public void withdraw(@RequestBody Account account, double amount) {
        accountServiceAdapter.withdraw(account,amount);
    }

    @GetMapping("/balance/{accountId}")
    public AccountDTO checkBalance(@PathVariable Long accountId) {
        return accountServiceAdapter.checkBalance(accountId);
    }

    @GetMapping("/transactions/{accountId}")
    public List<TransactionDTO> getTransactions(@PathVariable Long accountId) {
        return accountServiceAdapter.getTransactions(accountId);
    }
}

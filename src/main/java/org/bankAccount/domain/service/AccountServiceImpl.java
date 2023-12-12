package org.bankAccount.domain.service;

import org.bankAccount.adapter.infrastructure.persistence.AccountRepository;
import org.bankAccount.domain.Dto.AccountDTO;
import org.bankAccount.domain.Dto.TransactionDTO;
import org.bankAccount.domain.model.Account;
import org.bankAccount.domain.model.Transaction;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

import static org.bankAccount.domain.Dto.TransactionDTO.mapTransactionToTransactionDTOList;

public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    public AccountServiceImpl(AccountRepository accountRepository,ModelMapper modelMapper) {
        this.accountRepository = accountRepository;
        this.modelMapper = modelMapper;
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
    public AccountDTO checkBalance(Long idAccount) {
        Optional<Account> account =  accountRepository.findById(idAccount);
        return new AccountDTO(account.map(Account::getBalance).orElse(0.0));
    }

    @Override
    public List<TransactionDTO> getTransactions(Long idAccount) {
        Optional<Account> account =  accountRepository.findById(idAccount);
        List<Transaction> transactions = account.map(Account::getTransactions).orElse(null);
        return mapTransactionToTransactionDTOList(modelMapper, transactions, TransactionDTO.class);
    }
}

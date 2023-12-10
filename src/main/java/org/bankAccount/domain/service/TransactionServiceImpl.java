package org.bankAccount.domain.service;

import org.bankAccount.domain.model.Transaction;
import org.bankAccount.domain.repository.TransactionRepository;

import java.util.List;

public class TransactionServiceImpl implements TransactionService{
    private TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
}

package org.bankAccount.domain.service;

import org.bankAccount.adapter.infrastructure.persistence.TransactionRepository;
import org.bankAccount.domain.model.Transaction;

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

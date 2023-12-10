package org.bankAccount.domain.repository;

import org.bankAccount.domain.model.Transaction;

import java.util.List;

public interface TransactionRepository {

    void save(Transaction transaction);
    List<Transaction> findAll();
}

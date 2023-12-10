package org.bankAccount.domain.service;

import org.bankAccount.domain.model.Transaction;

import java.util.List;

public interface TransactionService {

    List<Transaction> getAllTransactions();
}

package org.bankAccount.adapter.infrastructure.persistence;

import org.bankAccount.domain.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}

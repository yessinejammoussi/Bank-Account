package org.bankAccount.domain.service;

import org.bankAccount.adapter.infrastructure.persistence.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class TransactionServiceTest {

    @InjectMocks
    TransactionServiceImpl transactionServiceImpl;
    @Mock
    TransactionRepository transactionRepository;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getTransactions() {
        transactionServiceImpl.getAllTransactions();
        verify(transactionRepository, times(1)).findAll();
    }
}

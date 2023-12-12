package org.bankAccount.domain.service;

import org.bankAccount.adapter.infrastructure.persistence.AccountRepository;
import org.bankAccount.domain.Dto.AccountDTO;
import org.bankAccount.domain.Dto.TransactionDTO;
import org.bankAccount.domain.model.Account;
import org.bankAccount.domain.model.Transaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Mock;
import org.mockito.stubbing.Answer;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.bankAccount.domain.Dto.TransactionDTO.mapTransactionToTransactionDTOList;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

public class AccountServiceTest {

    @InjectMocks
    AccountServiceImpl accountServiceImpl;
    @Mock
    AccountRepository accountRepository;

    @Mock
    ModelMapper modelMapper;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    void deposit_negative_Amount() {
        Account account = new Account( 20.5,null);
        Double amount = (double) -13;
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> accountServiceImpl.deposit( account, amount));
        Assertions.assertEquals("Invalid deposit amount", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({ "100, 30", "23, 20"})
    void deposit_with_Success(double balance, double amount) {
        Account account = new Account( balance,new ArrayList<>());
        accountServiceImpl.withdraw( account, amount);
        verify(accountRepository, times(1)).save(account);
    }

    @ParameterizedTest
    @CsvSource({ "20.5, 30", "23, -30"})
    void withdraw_with_insufficient_balance(double balance, double amount) {
        Account account = new Account( balance,new ArrayList<>());
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> accountServiceImpl.withdraw( account, amount));
        Assertions.assertEquals("Your balance is insufficient", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({ "100, 30", "23, 20"})
    void withdraw_with_Success(double balance, double amount) {
        Account account = new Account( balance,new ArrayList<>());
        accountServiceImpl.withdraw( account, amount);
        verify(accountRepository, times(1)).save(account);
    }

    @ParameterizedTest
    @CsvSource({ "20.5, 20.5", "23, 23", "0.0, 0.0"})
    void checkBalance(double amount, double expected) {
        Long idAccount = 123456L;
        Account account = new Account( idAccount, amount,null);
        when(accountRepository.findById(idAccount)).thenReturn(Optional.of(account));
        Assertions.assertEquals(expected, accountServiceImpl.checkBalance(idAccount).getBalance());
    }

    @Test
    void getTransactions() {
        TransactionDTO transaction = new TransactionDTO(50.0, LocalDateTime.now());
        List<TransactionDTO> transactions = new ArrayList<>();
        transactions.add(transaction);
        Account  account = new Account( 50.0,mapTransactionToTransactionDTOList(modelMapper, transactions, Transaction.class));
        when(accountRepository.findById(50L)).thenReturn(Optional.of(account));
        when(accountServiceImpl.getTransactions(50L)).thenReturn(transactions);
        Assertions.assertEquals(transactions, accountServiceImpl.getTransactions(50L).get(0));
    }
}

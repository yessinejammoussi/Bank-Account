package org.bankAccount.domain.Dto;

import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransactionDTO {

    private LocalDateTime timestamp;
    private double amount;

    public TransactionDTO(Double amount, LocalDateTime timestamp) {
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public static <Transaction, TransactionDTO> List<TransactionDTO> mapTransactionToTransactionDTOList(
            ModelMapper modelMapper, List<Transaction> transaction, Class<TransactionDTO> transactionDTO) {
        List<TransactionDTO> transactionDtoList = new ArrayList<>();
        for (Transaction element : transaction) {
            TransactionDTO destinationObject = modelMapper.map(element, transactionDTO);
            transactionDtoList.add(destinationObject);
        }
        return transactionDtoList;
    }
}

package com.educacaovirtual.transaction_api.services;

import com.educacaovirtual.transaction_api.domain.dtos.TransactionDTO;
import com.educacaovirtual.transaction_api.domain.entities.Transaction;

import java.util.List;
import java.util.UUID;

public interface TransactionService {
    Transaction save(TransactionDTO transactionId);
    List<Transaction> findAll();
    Transaction findById(UUID id);
    Transaction update(UUID id, TransactionDTO transactionDTO);
    void delete(UUID id);
}

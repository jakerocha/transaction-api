package com.educacaovirtual.transaction_api.services;

import com.educacaovirtual.transaction_api.domain.dtos.TransactionDTO;
import com.educacaovirtual.transaction_api.domain.entities.Transaction;
import com.educacaovirtual.transaction_api.repositories.TransactionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService{

    private final TransactionRepository transationRepository;

    public TransactionServiceImpl(TransactionRepository transationRepository) {
        this.transationRepository = transationRepository;
    }

    @Override
    public Transaction save(TransactionDTO transactionDTO) {
        Transaction transaction  = new Transaction();
        BeanUtils.copyProperties(transactionDTO, transaction);
        return transationRepository.save(transaction);
    }

    @Override
    public List<Transaction> findAll() {
        return transationRepository.findAll();
    }

    @Override
    public Transaction findById(UUID id) {
        return transationRepository.findById(id).get();
    }

    @Override
    public Transaction update(UUID id, TransactionDTO transactionDTO) {
        Optional<Transaction> transaction = transationRepository.findById(id);
        if (!transaction.isPresent()){
            throw new RuntimeException("Transaction no found");
        }
        BeanUtils.copyProperties(transactionDTO, transaction);
        return transationRepository.save(transaction.get());
    }

    @Override
    public void delete(UUID id) {
        Optional<Transaction> transaction = transationRepository.findById(id);
        if (!transaction.isPresent()){
            throw new RuntimeException("Transaction no found");
        }
        transationRepository.delete(transaction.get());
    }
}

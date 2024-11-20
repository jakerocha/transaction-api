package com.educacaovirtual.transaction_api.controllers;

import com.educacaovirtual.transaction_api.domain.dtos.TransactionDTO;
import com.educacaovirtual.transaction_api.domain.entities.Transaction;
import com.educacaovirtual.transaction_api.services.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    @Operation(summary = "Create a Transaction", description = "Create a new transaction.")
    public ResponseEntity<Transaction> save(@RequestBody TransactionDTO transactionDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(transactionService.save(transactionDTO));
    }

    @GetMapping
    @Operation(summary = "List All Transactions", description = "Retrieves alls transactions created")
    public ResponseEntity<List<Transaction>> listAll() {
        List<Transaction> transactions = transactionService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(transactions);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find Transaction by Id", description = "Retrieves a transaction based on its unique identifier.")
    public ResponseEntity<Transaction> findById(@PathVariable("id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(transactionService.findById(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Transaction by Id", description = "Update a transaction based on its unique identifier.")
    public ResponseEntity<Transaction> update(@PathVariable("id") UUID id, @RequestBody TransactionDTO transactionDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(transactionService.update(id, transactionDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a Transaction by Id", description = "Delete a transaction based on its unique identifier.")
    public ResponseEntity<String> delete(@PathVariable("id") UUID id) {
        transactionService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("transaction deleted");
    }

}
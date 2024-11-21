package com.example.web_inventory.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.web_inventory.dtos.request.TransactionRequestDTO;
import com.example.web_inventory.dtos.response.TransactionResponseDTO;
import com.example.web_inventory.entities.TransactionEntity;
import com.example.web_inventory.services.TransactionService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/transaction")
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<TransactionResponseDTO> createTransaction(@RequestBody TransactionRequestDTO dto) {

        TransactionEntity transaction = transactionService.createTransaction(dto);

        return ResponseEntity.status(201).body(new TransactionResponseDTO(transaction));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionEntity> findTransactionById(@PathVariable Long id) {

        TransactionEntity entity = this.transactionService.findTransactionById(id);

        return ResponseEntity.ok(entity);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TransactionEntity> getAllCustomers() {

        List<TransactionEntity> transaction = transactionService.getAllTransactions();

        return transaction;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<TransactionEntity> updateTransactionById(@PathVariable(value = "id") Long id,
            @RequestBody TransactionRequestDTO dto) {

        return transactionService.updateTransactionById(dto, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTransactionById(@PathVariable("id") Long id) {

        return transactionService.deleteById(id);
    }
}

package com.example.web_inventory.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.web_inventory.dtos.request.TransactionRequestDTO;
import com.example.web_inventory.entities.TransactionEntity;
import com.example.web_inventory.repositories.TransactionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionService {
    
    @Autowired
    private TransactionRepository repository;

    public TransactionEntity createTransaction(TransactionRequestDTO dto) {
        TransactionEntity entity = new TransactionEntity(dto);

        return repository.save(entity);
    }

    public TransactionEntity findTransactionById(Long id) {
        Optional<TransactionEntity> transaction = this.repository.findById(id);

        return transaction.orElseThrow(() -> new ObjectNotFoundException(
                "Transação não encontrada! Id: " + id + "Tipo: " + TransactionEntity.class.getName(), transaction));
    }

    public List<TransactionEntity> getAllTransactions() {

        return repository.findAll();
    }

    public ResponseEntity<TransactionEntity> updateTransactionById(TransactionRequestDTO dto, Long id) {
        return repository.findById(id)
        .map(update -> {
            update.setValue(dto.getValue());
            update.setTransactionType(dto.getTransactionType());
            TransactionEntity updated = repository.save(update);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Object> deleteById(Long id) {
        return repository.findById(id)
        .map(delete -> {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}

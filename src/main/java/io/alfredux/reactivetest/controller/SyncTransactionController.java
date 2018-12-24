package io.alfredux.reactivetest.controller;


import io.alfredux.reactivetest.entities.Transaction;
import io.alfredux.reactivetest.repository.SyncTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("sync-trx")
public class SyncTransactionController {

    @Autowired
    SyncTransactionRepository transactionRepository;

    @GetMapping
    public List<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Transaction> addTransatcion(@RequestBody @Valid Transaction transaction) {
        return ResponseEntity.accepted().body(transactionRepository.save(transaction));
    }

}

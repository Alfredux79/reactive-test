package io.alfredux.reactivetest.controller;


import io.alfredux.reactivetest.entities.Transaction;
import io.alfredux.reactivetest.repository.ReactiveTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import javax.validation.Valid;

@RestController
@RequestMapping("trx")
public class ReactiveTransactionController {

    @Autowired
    ReactiveTransactionRepository transactionRepository;

    @GetMapping
    public Flux<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }

    @PostMapping
    public Flux<Transaction> namesByLastname(@RequestBody @Valid Flux<Transaction> transactionFlux) {
        return transactionRepository.saveAll(transactionFlux);
    }

}

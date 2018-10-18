package io.alfredux.reactivetest.controller;


import io.alfredux.reactivetest.entities.Transaction;
import io.alfredux.reactivetest.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class TransactionController {

    @Autowired
    TransactionRepository transactionRepository;

    @GetMapping
    Flux<Transaction> getTransactions(){
        return  transactionRepository.findAll();
    }

}

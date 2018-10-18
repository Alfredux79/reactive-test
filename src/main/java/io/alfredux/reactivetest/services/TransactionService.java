package io.alfredux.reactivetest.services;

import io.alfredux.reactivetest.entities.Transaction;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class TransactionService {

    public Flux<Transaction> processTransactions(Flux<Transaction> transactionFlux){

        return transactionFlux;

    }


}

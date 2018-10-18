package io.alfredux.reactivetest.repository;

import io.alfredux.reactivetest.entities.Transaction;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TransactionRepository extends ReactiveCrudRepository<Transaction, String> {

}

package io.alfredux.reactivetest.repository;

import io.alfredux.reactivetest.entities.Transaction;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ReactiveTransactionRepository extends ReactiveCrudRepository<Transaction, String> {

}

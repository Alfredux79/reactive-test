package io.alfredux.reactivetest.repository;

import io.alfredux.reactivetest.entities.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SyncTransactionRepository extends MongoRepository<Transaction, String> {

}

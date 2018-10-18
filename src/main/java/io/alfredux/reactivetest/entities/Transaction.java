package io.alfredux.reactivetest.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
public class Transaction {

    @Id
    private String id;

    private LocalDateTime timestamp;

    private Double amount;

}

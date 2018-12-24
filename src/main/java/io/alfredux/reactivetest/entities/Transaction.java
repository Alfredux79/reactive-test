package io.alfredux.reactivetest.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Document
@Data
public class Transaction {

    @Id
    @JsonProperty("id")
    private String id;

    @JsonFormat(shape = JsonFormat.Shape.NUMBER, pattern = "s")
    @JsonProperty("timestamp")
    private Date timestamp;

    @NotNull
    @JsonProperty("amount")
    private Double amount;

}

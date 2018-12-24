package io.alfredux.reactivetest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.alfredux.reactivetest.repository.SyncTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UtilController {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    SyncTransactionRepository transactionRepository;

    @PostMapping("echo")
    public Object echo(@RequestBody Object body) throws JsonProcessingException {
        System.out.println(objectMapper.writeValueAsString(body));
        return body;
    }

    @GetMapping("clear")
    public void clearRepository() {
        transactionRepository.deleteAll();
    }
}

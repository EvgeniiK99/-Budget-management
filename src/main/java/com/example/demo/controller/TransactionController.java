package com.example.demo.controller;

import com.example.demo.exceptions.NonValidData;
import com.example.demo.model.Transaction;
import com.example.demo.service.TransactionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/")
    @ApiOperation("Create transaction")
    public ResponseEntity<?> create(@RequestBody Transaction transaction) throws NonValidData {
        transactionService.create(transaction);
        if (transaction.getIncome() == 0 && transaction.getOutcome() == 0) {
            throw new NonValidData();
        } else {
            return new ResponseEntity<>(transaction, HttpStatus.CREATED);
        }
    }

    @GetMapping(value = "/")
    @ApiOperation("Get all transactions")
    public ResponseEntity<List<Transaction>> read() {
        final List<Transaction> transactions = transactionService.readAll();

        return transactions != null && !transactions.isEmpty()
                ? new ResponseEntity<>(transactions, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation("Get transaction")
    public ResponseEntity<Transaction> read(@PathVariable(name = "id") int id) {
        final Transaction transaction = transactionService.read(id);

        return transaction != null
                ? new ResponseEntity<>(transaction, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Delete transaction")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = transactionService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}

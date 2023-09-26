package com.example.demo.repository;

import com.example.demo.model.Transaction;
import com.example.demo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public void create(Transaction transaction) {
        if (transaction.getDate() == null) {
            transaction.setDate(new Date());
        }
        transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction>  readAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction read(int id) {
        return transactionRepository.getById(id);
    }

    @Override
    public boolean update(Transaction client, int id) {
        if (transactionRepository.existsById(id)) {
            client.setId(id);
            transactionRepository.save(client);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        if (transactionRepository.existsById(id)) {
            transactionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

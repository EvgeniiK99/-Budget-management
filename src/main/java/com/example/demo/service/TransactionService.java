package com.example.demo.service;

import com.example.demo.model.Transaction;

import java.util.List;

public interface TransactionService {

    /**
     * Create new transaction
     * @param transaction - клиент для создания
     */
    void create(Transaction transaction);

    /**
     * Return list of all transaction
     * @return список клиентов
     */
    List<Transaction> readAll();

    /**
     * Возвращает клиента по его ID
     * @param id - ID клиента
     * @return - объект клиента с заданным ID
     */
    Transaction read(int id);

    /**
     * Обновляет клиента с заданным ID,
     * в соответствии с переданным клиентом
     * @param transaction - клиент в соответсвии с которым нужно обновить данные
     * @param id - id клиента которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    boolean update(Transaction transaction, int id);

    /**
     * Удаляет клиента с заданным ID
     * @param id - id клиента, которого нужно удалить
     * @return - true если клиент был удален, иначе false
     */
    boolean delete(int id);
}

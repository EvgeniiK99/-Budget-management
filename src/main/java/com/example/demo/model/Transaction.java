package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "operations")
public class Transaction {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "date")
    @GeneratedValue()
    private Date date;

    @Column(name = "description")
    private String description;

    @Column(name = "income")
    private int income;

    @Column(name = "outcome")
    private int outcome;

    @Column(name = "balance")
    private int balance;

//    private OperationType operationType;
//    public enum OperationType {
//        INCOME, OUTCOME
//    }
}

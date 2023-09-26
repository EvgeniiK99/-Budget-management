package com.example.demo.exceptions;

public class NonValidData extends Exception {
    public NonValidData() {
        super("income or outcome must be filled");
    }
}

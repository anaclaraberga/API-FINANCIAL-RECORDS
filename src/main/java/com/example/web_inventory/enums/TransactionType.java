package com.example.web_inventory.enums;

public enum TransactionType {
    ENTRADA("Entrada"),
    SAÍDA("Saída");

    private final String text;

    TransactionType(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}
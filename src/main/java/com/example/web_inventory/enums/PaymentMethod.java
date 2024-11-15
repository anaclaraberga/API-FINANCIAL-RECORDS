package com.example.web_inventory.enums;

public enum PaymentMethod {
    CASH("Cash"),
    CREDIT_CARD("Credit Card"),
    PIX("Pix");

    private final String text;

    PaymentMethod(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}

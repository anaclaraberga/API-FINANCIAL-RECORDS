package com.example.web_inventory.enums;

public enum Status {
    ACTIVE("Active"),
    INACTIVE("Inactive"),
    DELETED("Deleted");

    private final String text;

    Status(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}

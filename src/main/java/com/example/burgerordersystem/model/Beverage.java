package com.example.burgerordersystem.model;

public enum Beverage {
    STILL_WATER("Still Water"),
    SPARKLING_WATER("Sparkling Water"),
    APPLE_JUICE("Apple Juice");

    private final String text;

    Beverage(String text) {
        this.text = text;
    }

    public String toString() {
        return this.text;
    }
}

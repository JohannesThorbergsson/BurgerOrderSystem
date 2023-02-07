package com.example.burgerordersystem.model;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public enum MainDish {
    HAMBURGER("Hamburger"),
    CHEESEBURGER("Cheeseburger"),
    VEGGIE_BURGER("Veggieburger"),
    SALMON_BURGER("Salmonburger");

    private final String burgerName;
}

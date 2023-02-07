package com.example.burgerordersystem.model;

public enum SideDish {
    FRIES("fries"),
    CURLY_FRIES("curly fries"),
    SALAD("salad");

    private final String sideDish;

    SideDish(String sideDish){
        this.sideDish = sideDish;
    }

    public String toString(){
        return this.sideDish;
    }
}

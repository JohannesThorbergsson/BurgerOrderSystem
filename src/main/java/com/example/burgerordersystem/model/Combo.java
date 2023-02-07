package com.example.burgerordersystem.model;

public record Combo (
        String id,
        String name,
        int price,
        MainDish mainDish,
        SideDish sideDish,
        Beverage beverage
){

}

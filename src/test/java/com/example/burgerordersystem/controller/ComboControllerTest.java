package com.example.burgerordersystem.controller;

import com.example.burgerordersystem.model.Beverage;
import com.example.burgerordersystem.model.Combo;
import com.example.burgerordersystem.model.MainDish;
import com.example.burgerordersystem.model.SideDish;
import com.example.burgerordersystem.repositories.ComboRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.MediaType;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
class ComboControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ComboRepository comboRepository;

    @BeforeEach
    void setUp() {
        Combo c1 = new Combo("1", "Combo 1", 20, MainDish.CHEESEBURGER, SideDish.FRIES, Beverage.SPARKLING_WATER);
        Combo c2 = new Combo("2", "Combo 2", 30, MainDish.SALMON_BURGER, SideDish.SALAD, Beverage.STILL_WATER);
        comboRepository.addCombo(c1);
        comboRepository.addCombo(c2);
    }

    @Test
    @DirtiesContext
    void listCombos() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/menus"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                    [
                    {"id":  "1",
                    "name": "Combo 1",
                    "price": 20,
                    "mainDish": "CHEESEBURGER",
                    "sideDish": "FRIES",
                    "beverage":  "SPARKLING_WATER"},
                    {"id":  "2"}
                    ]
                """));
    }

    @Test
    @DirtiesContext
    void getCombo() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/menus/1"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                {
                "id": "1",
                "name": "Combo 1",
                "price": 20,
                "mainDish": "CHEESEBURGER",
                "sideDish": "FRIES",
                "beverage":  "SPARKLING_WATER"
                }
"""));
    }

    @Test
    @DirtiesContext
    void addCombo() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/menus")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                        "id":"2",
                        "name":"Combo 2",
                        "price": 20,
                        "mainDish": "SALMON_BURGER",
                        "sideDish": "SALAD" ,
                        "beverage": "STILL_WATER"
                        }
                        """
                ))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        """
                        {
                        "id":"2",
                        "name":"Combo 2",
                        "price": 20,
                        "mainDish": "SALMON_BURGER",
                        "sideDish": "SALAD" ,
                        "beverage": "STILL_WATER"
                        }
                        """
                ));
    }
}
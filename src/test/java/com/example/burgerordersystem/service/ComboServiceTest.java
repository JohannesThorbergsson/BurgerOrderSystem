package com.example.burgerordersystem.service;

import com.example.burgerordersystem.model.Beverage;
import com.example.burgerordersystem.model.Combo;
import com.example.burgerordersystem.model.MainDish;
import com.example.burgerordersystem.model.SideDish;
import com.example.burgerordersystem.repositories.ComboRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ComboServiceTest {
    Combo combo1, combo2;
    Map<String, Combo> shortComboMap;
    ComboRepository comboRepository;
    ComboService comboService;

    @BeforeEach
    void setUp() {
        combo1 = new Combo("1", "Walle's Combo", 20, MainDish.CHEESEBURGER, SideDish.CURLY_FRIES, Beverage.APPLE_JUICE);
        combo2 = new Combo("2", "Johannes Combo", 15, MainDish.HAMBURGER, SideDish.FRIES, Beverage.SPARKLING_WATER);
        shortComboMap = new HashMap<>(Map.of(
                combo1.id(), combo1
        ));
        comboRepository = mock(ComboRepository.class);
        comboService = new ComboService(comboRepository);
    }

    @Test
    void listCombos() {
        // GIVEN
        Map<String, Combo> expectedCombos = shortComboMap;
        when(comboRepository.listCombos()).thenReturn(expectedCombos);
        // WHEN
        Map<String,Combo> actualCombos = comboService.listCombos();
        // THEN
        verify(comboRepository).listCombos();
        Assertions.assertEquals(expectedCombos, actualCombos);
    }
    @Test
    void getComboById(){
        //GIVEN
        Combo expectedCombo = combo1;
        when(comboRepository.getComboById("1")).thenReturn(expectedCombo);
        //WHEN
        Combo actualCombo = comboService.getComboById("1");
        //THEN
        verify(comboRepository).getComboById("1");
        Assertions.assertEquals(expectedCombo, actualCombo);
    }
    @Test
    void addCombo(){
        //GIVEN
        Combo comboExpectedAdded = combo2;
        when(comboRepository.addCombo(combo2)).thenReturn(comboExpectedAdded);
        //WHEN
        Combo actualCombo = comboService.addCombo(comboExpectedAdded);
        //THEN
        verify(comboRepository).addCombo(combo2);
        Assertions.assertEquals(comboExpectedAdded,actualCombo);
    }
}
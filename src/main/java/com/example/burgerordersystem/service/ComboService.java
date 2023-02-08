package com.example.burgerordersystem.service;

import com.example.burgerordersystem.model.Combo;
import com.example.burgerordersystem.repositories.ComboRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
@RequiredArgsConstructor
public class ComboService {
    private final ComboRepository comboRepository;

    public List<Combo> listCombos() {
        return comboRepository.listCombos().values().stream().toList();
    }

    public Combo getComboById(String id) {
        return comboRepository.getComboById(id);
    }

    public Combo addCombo(Combo combo) {
        return comboRepository.addCombo(combo);
    }
}

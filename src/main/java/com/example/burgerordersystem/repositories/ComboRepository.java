package com.example.burgerordersystem.repositories;

import com.example.burgerordersystem.model.Combo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Map;

@RequiredArgsConstructor
@Repository
public class ComboRepository {
    private final Map<String, Combo> comboMap;

    public Map<String, Combo> listCombos() {
        return comboMap;
    }

    public Combo getComboById(String id) {
        return comboMap.get(id);
    }

    public Combo addCombo(Combo combo) {
        comboMap.put(combo.id(), combo);
        return combo;
    }

}

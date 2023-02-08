package com.example.burgerordersystem.controller;

import com.example.burgerordersystem.model.Combo;
import com.example.burgerordersystem.service.ComboService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ComboController {
    private final ComboService comboService;

    @GetMapping("/menus")
    public Map<String, Combo> listCombos()
    {
        return comboService.listCombos();
    }

    @GetMapping("menus/{id}")
    public Combo getCombo(@PathVariable String id) {
        return comboService.getComboById(id);
    }

    @PostMapping("/menus")
    public Combo addCombo(@RequestBody Combo addedCombo){
        return comboService.addCombo(addedCombo);
    }
}

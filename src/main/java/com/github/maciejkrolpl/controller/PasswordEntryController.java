package com.github.maciejkrolpl.controller;

import com.github.maciejkrolpl.dto.PasswordEntryDto;
import com.github.maciejkrolpl.dto.PasswordEntrySaveDto;
import com.github.maciejkrolpl.model.PasswordEntry;
import com.github.maciejkrolpl.service.PasswordEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/password-bank")
public class PasswordEntryController {

    private PasswordEntryService service;

    @Autowired
    public PasswordEntryController(PasswordEntryService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public PasswordEntry findOne(@PathVariable Long id) {
        return service.findOneById(id);
    }

    @GetMapping
    public Set<PasswordEntry> findAll() {
        return service.findAll();
    }

    @PostMapping
    public PasswordEntryDto create(@RequestBody PasswordEntrySaveDto passwordEntrySaveDto) {
        PasswordEntry passwordEntry = service.createPasswordEntry(passwordEntrySaveDto);
        return new PasswordEntryDto(passwordEntry);
    }

    @DeleteMapping
    public void delete(Long id) {
        service.deleteOneById(id);
    }

}

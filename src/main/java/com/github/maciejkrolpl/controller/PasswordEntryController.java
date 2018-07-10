package com.github.maciejkrolpl.controller;

import com.github.maciejkrolpl.dto.PasswordEntryDto;
import com.github.maciejkrolpl.dto.PasswordEntrySaveDto;
import com.github.maciejkrolpl.model.PasswordEntry;
import com.github.maciejkrolpl.service.PasswordEntryService;
import jdk.internal.org.objectweb.asm.Handle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
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
    public PasswordEntryDto findOne(@PathVariable Long id) {
        PasswordEntry passwordEntry = service.findOneById(id);
        return new PasswordEntryDto(passwordEntry);
    }

    @PutMapping
    public PasswordEntryDto edit(@RequestBody PasswordEntryDto passwordEntryDto) {
        PasswordEntry passwordEntry = service.editPasswordEntry(passwordEntryDto);
        return new PasswordEntryDto(passwordEntry);
    }


    @GetMapping
    public Set<PasswordEntryDto> findAll() {
        Set<PasswordEntry> passwordEntries = service.findAll();
        Set<PasswordEntryDto> passwordEntryDtos = new HashSet<>();
        passwordEntries.forEach(pe -> passwordEntryDtos.add(new PasswordEntryDto(pe)));
        return passwordEntryDtos;
    }

    @PostMapping
    public PasswordEntryDto create(@RequestBody PasswordEntrySaveDto passwordEntrySaveDto) {
        PasswordEntry passwordEntry = service.createPasswordEntry(passwordEntrySaveDto);
        return new PasswordEntryDto(passwordEntry);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteOneById(id);
    }

}

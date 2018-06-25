package com.github.maciejkrolpl.controller;

import com.github.maciejkrolpl.model.PasswordEntry;
import com.github.maciejkrolpl.service.PasswordEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
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
    public PasswordEntry create(PasswordEntry passwordEntry) {
        return service.createPasswordEntry(passwordEntry);
    }

    @DeleteMapping
    public void delete(Long id) {
        service.deleteOneById(id);
    }

}

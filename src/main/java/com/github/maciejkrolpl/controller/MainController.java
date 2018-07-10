package com.github.maciejkrolpl.controller;

import com.github.maciejkrolpl.dto.PasswordEntryDto;
import com.github.maciejkrolpl.dto.PasswordEntryHtmlDto;
import com.github.maciejkrolpl.model.PasswordEntry;
import com.github.maciejkrolpl.service.PasswordEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashSet;
import java.util.Set;

@Controller
public class MainController {

    private PasswordEntryService service;

    @Autowired
    public MainController(PasswordEntryService service) {
        this.service = service;
    }

    @RequestMapping(value = {
            "/",
            "/index"
    }, method = RequestMethod.GET)
    public String index(Model model) {
        Set<PasswordEntry> passwordEntries = service.findAll();
        Set<PasswordEntryHtmlDto> dtos = new HashSet<>();
        passwordEntries.forEach(pe -> dtos.add(new PasswordEntryHtmlDto(pe)));
        model.addAttribute("entries", dtos);
        return "index";

    }

}

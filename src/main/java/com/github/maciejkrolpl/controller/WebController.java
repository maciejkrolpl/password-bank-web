package com.github.maciejkrolpl.controller;

import com.github.maciejkrolpl.dto.PasswordEntryHtmlDto;
import com.github.maciejkrolpl.model.PasswordEntry;
import com.github.maciejkrolpl.service.PasswordEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class WebController {

    private PasswordEntryService service;

    @Autowired
    public WebController(PasswordEntryService service) {
        this.service = service;
    }

    @RequestMapping(value = {
            "/",
            "/index"
    }, method = RequestMethod.GET)
    public String index(Model model) {
        Set<PasswordEntryHtmlDto> dtos = service.findAll().stream()
                .map(PasswordEntryHtmlDto::new)
                .collect(Collectors.toSet());
        model.addAttribute("entries", dtos);
        return "index";
    }

    @RequestMapping( value = "/entry/{id}", method = RequestMethod.GET)
    public String entry(Model model, @PathVariable Long id) {
        PasswordEntry entry = service.findOneById(id);
        PasswordEntryHtmlDto dto = new PasswordEntryHtmlDto(entry);
        model.addAttribute("entry", dto);
        return "entry";

    }

}

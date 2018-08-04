package com.github.maciejkrolpl.controller;

import com.github.maciejkrolpl.dto.PasswordEntryDto;
import com.github.maciejkrolpl.dto.PasswordEntryHtmlDto;
import com.github.maciejkrolpl.dto.PasswordEntrySaveDto;
import com.github.maciejkrolpl.model.PasswordEntry;
import com.github.maciejkrolpl.service.PasswordEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable Long id) {
        PasswordEntry entry = service.findOneById(id);
        PasswordEntryHtmlDto dto = new PasswordEntryHtmlDto(entry);
        model.addAttribute("entry", dto);
        return "edit";
    }


    @PostMapping("/save")
    public String save(@ModelAttribute("entry") PasswordEntryDto dto, Model model) {
        PasswordEntry passwordEntrySaved = service.editPasswordEntry(dto);

        model.addAttribute("entry", dto);

        return "save";


    }

    @PostMapping("/submit")
    public String submit(@ModelAttribute("entry") PasswordEntryDto dto, BindingResult bindingResult, Model model) {

        if (dto.getService().equals("")) {
            bindingResult.rejectValue("service", "error.service", "No service entered!");
        }

        if (dto.getLogin().equals("")) {
            bindingResult.rejectValue("login", "error.login", "No login entered!");
        }

        if (dto.getPassword().equals("")) {
            bindingResult.rejectValue("password", "error.password", "No password entered!");
        }

        if (bindingResult.hasErrors()) {
            return "edit";
        }

        return "submit";
    }

}
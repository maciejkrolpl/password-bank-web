package com.github.maciejkrolpl.dto;

import com.github.maciejkrolpl.model.PasswordEntry;

public class PasswordEntryDto {

    private Long id;
    private String service;
    private String login;
    private String password;

    public PasswordEntryDto(PasswordEntry passwordEntry) {
        this.service = passwordEntry.getService();
        this.login = passwordEntry.getLogin();
        this.password = passwordEntry.getPassword();
        this.id = passwordEntry.getId();
    }

    public PasswordEntryDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

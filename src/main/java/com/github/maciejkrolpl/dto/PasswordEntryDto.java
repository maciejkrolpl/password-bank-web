package com.github.maciejkrolpl.dto;

import com.github.maciejkrolpl.model.PasswordEntry;

public class PasswordEntryDto {

    private String service;
    private String login;
    private Byte[] password;

    public PasswordEntryDto(PasswordEntry passwordEntry) {
        this.service = passwordEntry.getService();
        this.login = passwordEntry.getLogin();
        this.password = passwordEntry.getPassword();
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

    public Byte[] getPassword() {
        return password;
    }

    public void setPassword(Byte[] password) {
        this.password = password;
    }
}

package com.github.maciejkrolpl.dto;

import com.github.maciejkrolpl.encrypt.EncryptDecrypt;
import com.github.maciejkrolpl.model.PasswordEntry;

public class PasswordEntryHtmlDto {

    private Long id;
    private String service;
    private String login;
    private String password;
    private String uuid;

    public PasswordEntryHtmlDto(PasswordEntry entry) {
        this.id = entry.getId();
        this.service = entry.getService();
        this.login = entry.getLogin();
        this.uuid = entry.getUuid();
        this.password = EncryptDecrypt.decrypt(entry.getPassword(), entry.getUuid());
    }

    public PasswordEntryHtmlDto() {
    }

    public Long getId() {
        return id;
    }

    public String getService() {
        return service;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}

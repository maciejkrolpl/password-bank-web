package com.github.maciejkrolpl.service;

import com.github.maciejkrolpl.model.PasswordEntry;

import java.util.Set;

public interface PasswordEntryService {

    PasswordEntry findOneById(Long id);

    Set<PasswordEntry> findAll();

    Set<PasswordEntry> findAllByService(String service);

    void deleteOneById(Long id);

    PasswordEntry createPasswordEntry(PasswordEntry passwordEntry);


}

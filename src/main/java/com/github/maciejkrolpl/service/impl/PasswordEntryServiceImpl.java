package com.github.maciejkrolpl.service.impl;

import com.github.maciejkrolpl.dto.PasswordEntrySaveDto;
import com.github.maciejkrolpl.model.PasswordEntry;
import com.github.maciejkrolpl.repository.PasswordEntryRepository;
import com.github.maciejkrolpl.service.PasswordEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class PasswordEntryServiceImpl implements PasswordEntryService {

    private PasswordEntryRepository repository;


    @Autowired
    public PasswordEntryServiceImpl(PasswordEntryRepository repository) {
        this.repository = repository;
    }

    @Override
    public PasswordEntry findOneById(Long id) {
        Optional<PasswordEntry> optionalEntry = repository.findById(id);

        if (optionalEntry.isPresent()) {
            PasswordEntry passwordEntry = optionalEntry.get();
            String password = passwordEntry.getPassword();

            passwordEntry.setPassword(password);
            return passwordEntry;
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public Set<PasswordEntry> findAll() {
        return new HashSet<>(repository.findAll());
    }

    @Override
    public Set<PasswordEntry> findAllByService(String service) {
        return new HashSet<>(repository.findAllByService(service));
    }

    @Override
    public void deleteOneById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public PasswordEntry createPasswordEntry(PasswordEntrySaveDto passwordEntrySaveDto) {
        PasswordEntry passwordEntry = new PasswordEntry();
        passwordEntry.setService(passwordEntrySaveDto.getService());
        passwordEntry.setLogin(passwordEntrySaveDto.getLogin());
        passwordEntry.setPassword(passwordEntrySaveDto.getPassword());

        return repository.save(passwordEntry);

    }
}

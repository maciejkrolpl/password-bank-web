package com.github.maciejkrolpl.service.impl;

import com.github.maciejkrolpl.dto.PasswordEntryDto;
import com.github.maciejkrolpl.dto.PasswordEntrySaveDto;
import com.github.maciejkrolpl.encrypt.EncryptDecrypt;
import com.github.maciejkrolpl.model.PasswordEntry;
import com.github.maciejkrolpl.repository.PasswordEntryRepository;
import com.github.maciejkrolpl.service.PasswordEntryService;
import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
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
        BasicTextEncryptor encryptor = new BasicTextEncryptor();

        if (optionalEntry.isPresent()) {
            return optionalEntry.get();
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
    public PasswordEntry createPasswordEntry(PasswordEntrySaveDto dto)  {
        BasicTextEncryptor encryptor = new BasicTextEncryptor();

        PasswordEntry passwordEntry = repository.save(new PasswordEntry());
        passwordEntry.setService(dto.getService());
        passwordEntry.setLogin(dto.getLogin());
        String password = dto.getPassword();

        encryptor.setPasswordCharArray(passwordEntry.getUuid().toCharArray());
        String encrypted = encryptor.encrypt(password);
        passwordEntry.setPassword(encrypted);

        return repository.save(passwordEntry);
    }

    @Override
    public PasswordEntry editPasswordEntry(Long id, PasswordEntryDto dto)  {

        Optional<PasswordEntry> optionalEntry = repository.findById(id);
        PasswordEntry passwordEntry;

        if (!optionalEntry.isPresent()) {
            throw new RuntimeException();
        } else {
            passwordEntry = optionalEntry.get();
            passwordEntry.setPassword(dto.getPassword());
            passwordEntry.setService(dto.getService());
            passwordEntry.setLogin(dto.getLogin());
        }

        return repository.save(passwordEntry);

    }

    }

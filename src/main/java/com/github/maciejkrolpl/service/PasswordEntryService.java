package com.github.maciejkrolpl.service;

import com.github.maciejkrolpl.dto.PasswordEntryDto;
import com.github.maciejkrolpl.dto.PasswordEntrySaveDto;
import com.github.maciejkrolpl.model.PasswordEntry;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Set;

public interface PasswordEntryService {

    PasswordEntry findOneById(Long id);

    Set<PasswordEntry> findAll();

    Set<PasswordEntry> findAllByService(String service);

    void deleteOneById(Long id);

    PasswordEntry createPasswordEntry(PasswordEntrySaveDto passwordEntrySaveDto);


    PasswordEntry editPasswordEntry(PasswordEntryDto dto);
}

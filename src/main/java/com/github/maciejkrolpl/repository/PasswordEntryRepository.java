package com.github.maciejkrolpl.repository;

import com.github.maciejkrolpl.model.PasswordEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface PasswordEntryRepository extends JpaRepository <PasswordEntry, Long> {

    Set<PasswordEntry> findAllByService(String service);

}

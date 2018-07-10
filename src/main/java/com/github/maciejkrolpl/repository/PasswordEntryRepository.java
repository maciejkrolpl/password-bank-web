package com.github.maciejkrolpl.repository;

import com.github.maciejkrolpl.model.PasswordEntry;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PasswordEntryRepository extends JpaRepository <PasswordEntry, Long> {

    Set<PasswordEntry> findAllByService(String service);

}

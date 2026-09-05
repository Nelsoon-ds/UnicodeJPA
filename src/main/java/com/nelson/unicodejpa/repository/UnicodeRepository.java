package com.nelson.unicodejpa.repository;

import com.nelson.unicodejpa.controller.model.Unicode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnicodeRepository extends JpaRepository<Unicode, Long> {
}

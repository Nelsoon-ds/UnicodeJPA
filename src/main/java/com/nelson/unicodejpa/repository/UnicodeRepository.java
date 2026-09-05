package com.nelson.unicodejpa.repository;

import com.nelson.unicodejpa.controller.model.Unicode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface UnicodeRepository extends JpaRepository<Unicode, Long> {
    List<Unicode> findAllByUnicodeIn(ArrayList<Integer> ids);
}

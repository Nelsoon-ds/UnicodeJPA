package com.nelson.unicodejpa.controller.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Unicode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    int unicode;
    char symbol;
    String description;

    public Unicode(int unicode, Character character) {
        this.unicode = unicode;
        this.symbol = character;
    }

    public Unicode() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getUnicode() {
        return unicode;
    }

    public void setUnicode(int unicode) {
        this.unicode = unicode;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

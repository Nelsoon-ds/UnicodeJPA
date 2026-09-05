package com.nelson.unicodejpa.config;

import com.nelson.unicodejpa.controller.model.Unicode;
import com.nelson.unicodejpa.repository.UnicodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    UnicodeRepository unicodeRepository;


    @Override
    public void run(String... args) throws Exception {
        Set<Character> collection = new HashSet<>();
        Set<Unicode> unicodes = new HashSet<>();
        int n = 0;
        int upperLim = 65536;
        for (int i = 0; i< upperLim; i++) {
            collection.add((char) n);
            n++;
        }
        for (Character character : collection) {
            int code = (int) character;
            Unicode unicode = new Unicode(code, character);
            unicodes.add(unicode);
        }

        unicodeRepository.saveAll(unicodes);

    }
}

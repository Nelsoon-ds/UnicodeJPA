package com.nelson.unicodejpa.controller;

import com.nelson.unicodejpa.repository.UnicodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnicodeController {

    @Autowired
    UnicodeRepository unicodeRepository;

    @GetMapping("/unicode/{i}")
    public String unicodeToChar(@PathVariable int i) {
        char c = (char)i;
        return "unicode=" + i + " char=" + c;

    }


    @GetMapping("/char/{c}")
    public String charToUnicode(@PathVariable char c) {

        int unicode = c;
        return "unicode=" + unicode + " char=" + c;

    }

}

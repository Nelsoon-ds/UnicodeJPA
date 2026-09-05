package com.nelson.unicodejpa.controller;

import com.nelson.unicodejpa.controller.model.Unicode;
import com.nelson.unicodejpa.repository.UnicodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @GetMapping("char/{c}/number/{n}")
    public Set<Character> returnNChars(@PathVariable char c, @PathVariable int n) {
        Set<Character> unicodes = new HashSet<>();
        ArrayList<Integer>ids = new ArrayList<>();
        for (int i = c; i < c + n; i++) {
            ids.add((i));
        }
        List<Unicode> unicodeList = unicodeRepository.findAllByUnicodeIn(ids); //

        // Build our list of unicodes to return
        for (Unicode unicode : unicodeList) {
            unicodes.add(unicode.getSymbol());
        }

        return unicodes;
    }
}

package com.nelson.unicodejpa.config;

import com.nelson.unicodejpa.controller.model.Unicode;
import com.nelson.unicodejpa.repository.UnicodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.*;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    UnicodeRepository unicodeRepository;


    @Override
    public void run(String... args) throws Exception {
//        StopWatch sw = new StopWatch();
//        Set<Character> collection = new HashSet<>();
//        Set<Unicode> unicodes = new HashSet<>();
//        int n = 0;
//        int upperLim = 65536;
//        for (int i = 0; i< upperLim; i++) {
//            collection.add((char) n);
//            n++;
//        }
//        for (Character character : collection) {
//            int code = (int) character;
//            Unicode unicode = new Unicode(code, character);
//            unicodes.add(unicode);
//        }
//
//        sw.start("Save all");
//        unicodeRepository.saveAll(unicodes);
//        sw.stop();
//        System.out.println(sw.prettyPrint()); Det tager den 21.3712 sekunder
//    }
        int upperLim = 65536;
List<Unicode> unicodeList = new ArrayList<>(upperLim);
        for (int i = 0; i< upperLim; i++) {
            unicodeList.add(new Unicode(i, (char)i ));
        }
        StopWatch sw = new StopWatch();
        sw.start("Save Unicodes");
        unicodeRepository.saveAll(unicodeList);
        sw.stop();
        System.out.println(sw.prettyPrint()); // omkring 19.8 sekunder

    }

    }

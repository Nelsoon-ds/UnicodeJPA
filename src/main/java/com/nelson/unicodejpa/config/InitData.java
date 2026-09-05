package com.nelson.unicodejpa.config;

import com.nelson.unicodejpa.controller.model.Unicode;
import com.nelson.unicodejpa.repository.UnicodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    UnicodeRepository unicodeRepository;


    @Override
    public void run(String... args) throws Exception {
        int upperLim = 65536;
        List<Unicode> unicodeList = new ArrayList<>(upperLim);
        for (int i = 0; i < upperLim; i++) {
            unicodeList.add(new Unicode(i, (char) i));
        }
        StopWatch sw = new StopWatch();
        sw.start("Save Unicodes");
        unicodeRepository.saveAll(unicodeList);
        sw.stop();
        System.out.println(sw.prettyPrint()); // omkring 19.8 sekunder

    }

}

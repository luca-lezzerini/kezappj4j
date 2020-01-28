package com.example.kezapp.controller;

import com.example.kezapp.model.RegistrazioneDto02;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KezappController02 {

    @RequestMapping(value = "/registrazione02")
    public RegistrazioneDto02 registrazione() {
        System.out.println("Siamo in registrazione!");
        RegistrazioneDto02 rx = new RegistrazioneDto02();
        rx.setSessione("123stella!");
        return rx;
    }

}

package com.example.kezapp.controller;

import com.example.kezapp.model.RegistrazioneDto00;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KezappController00 {

    @RequestMapping(value = "/registrazione00")
    public RegistrazioneDto00 registrazione() {
        System.out.println("Siamo in registrazione!");
        RegistrazioneDto00 rx = new RegistrazioneDto00();
        rx.setSessione("123stella!");
        return rx;
    }

}

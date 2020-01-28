package com.example.kezapp.controller;

import com.example.kezapp.model.RegistrazioneDto02;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KezappController02 {

    @RequestMapping(value = "/registrazione02")
    public RegistrazioneDto02 registrazione() {
        System.out.println("Siamo in registrazione!");
        return new RegistrazioneDto02();
    }
    @RequestMapping(value = "/inviaTutti02")
    public RegistrazioneDto02 inviaTutti() {
        System.out.println("Siamo in registrazione!");
        return new RegistrazioneDto02();
    }
    @RequestMapping(value = "/inviaUno02")
    public RegistrazioneDto02 inviaUno() {
        System.out.println("Siamo in registrazione!");
        return new RegistrazioneDto02();
    }
    @RequestMapping(value = "/aggiorna02")
    public RegistrazioneDto02 aggiorna() {
        System.out.println("Siamo in registrazione!");
        return new RegistrazioneDto02();
    }

}

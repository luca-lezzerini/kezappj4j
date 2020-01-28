package com.example.kezapp.controller;

import com.example.kezapp.model.RegistrazioneDto04;
//import com.example.kezapp.model.RichiediRegistrazioneDto04;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KezappController04 {

    @RequestMapping(value = "/registrazione04")
    public RegistrazioneDto04 registrazione(/*RichiediRegistrazioneDto04 reg*/) {
        System.out.println("Siamo in registrazione");
        return new RegistrazioneDto04();
    }

    @RequestMapping(value = "/invia-tutti04")
    public RegistrazioneDto04 inviaTutti() {
        System.out.println("Siamo in inviaTutti");
        return new RegistrazioneDto04();
    }

    @RequestMapping(value = "/invia-uno04")
    public RegistrazioneDto04 inviaUno() {
        System.out.println("Siamo in inviaUno");
        return new RegistrazioneDto04();
    }

    @RequestMapping(value = "/aggiorna04")
    public RegistrazioneDto04 aggiorna() {
        System.out.println("Siamo in aggiorna");
        return new RegistrazioneDto04();
    }
}

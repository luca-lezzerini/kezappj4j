package com.example.kezapp.controller;

import com.example.kezapp.model.RegistrazioneDto06;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KezappController06 {

    @RequestMapping(value = "/registrazione06")
    public RegistrazioneDto06 registrazione(/*RichiediRegistrazioneDto06 reg*/) {
        System.out.println("Siamo in registrazione");
        return new RegistrazioneDto06();
    }

    @RequestMapping(value = "/invia-tutti06")
    public RegistrazioneDto06 inviaTutti() {
        System.out.println("Inviato a tutti");
        return new RegistrazioneDto06();
    }

    @RequestMapping(value = "/invia06")
    public RegistrazioneDto06 inviaUno() {
        System.out.println("Inviato a una persona");
        return new RegistrazioneDto06();
    }

    @RequestMapping(value = "/aggiorna06")
    public RegistrazioneDto06 aggiorna() {
        System.out.println("Aggiornamento");
        return new RegistrazioneDto06();
    }
}

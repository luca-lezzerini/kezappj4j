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
}

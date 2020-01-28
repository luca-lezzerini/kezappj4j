package com.example.kezapp.controller;

import com.example.kezapp.model.RegistrazioneDto10;
import com.example.kezapp.model.RichiediRegistrazioneDto10;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KezappController10 {
    
    @RequestMapping(value = "/registrazione10")
    public RegistrazioneDto10 registrazione(){
        System.out.println("Siamo in registrazione!");
        RegistrazioneDto10 rx = new RegistrazioneDto10();
        rx.setSessione("123stella!");
        return rx;
    }
    
    @RequestMapping(value = "/inviatutti10")
    public RegistrazioneDto10 inviaTutti(){
        System.out.println("Siamo in Invia Tutti!");
        RegistrazioneDto10 rx = new RegistrazioneDto10();
        rx.setSessione("Sessione Invia Tutti");
        return rx;
    }
    
    @RequestMapping(value = "/inviauno10")
    public RegistrazioneDto10 inviaUno(){
        System.out.println("Siamo in Invia Uno!");
        RegistrazioneDto10 rx = new RegistrazioneDto10();
        rx.setSessione("Sessione Invia Uno!");
        return rx;
    }
   
    @RequestMapping(value = "/aggiorna10")
    public RegistrazioneDto10 aggiorna(){
        System.out.println("Siamo in aggiorna!");
        RegistrazioneDto10 rx = new RegistrazioneDto10();
        rx.setSessione("Sessione Aggiorna!");
        return rx;
    }
    
    
}
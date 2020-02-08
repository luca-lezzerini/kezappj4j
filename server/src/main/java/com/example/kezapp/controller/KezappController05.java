/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.kezapp.controller;

import com.example.kezapp.model.RegistrazioneDto05;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author utente
 */
@RestController
public class KezappController05 {
    @RequestMapping(value = "/registrazione05")
    public RegistrazioneDto05 registrazione(){
        System.out.println("Siamo in registrazione");
        RegistrazioneDto05 rx = new RegistrazioneDto05();
        rx.setSessione("123stella");
        return rx;
    }
    
    @RequestMapping(value = "/inviatutti05")
    public RegistrazioneDto05 inviaTutti(){
        System.out.println("Siamo in invia a tutti");
        RegistrazioneDto05 rx = new RegistrazioneDto05();
        rx.setSessione("123stella");
        return rx;
    }
    
    @RequestMapping(value = "/inviauno05")
    public RegistrazioneDto05 inviaUno(){
        System.out.println("Siamo in invia a uno");
        RegistrazioneDto05 rx = new RegistrazioneDto05();
        rx.setSessione("123stella");
        return rx;
    }
    
    @RequestMapping(value = "/aggiorna05")
    public RegistrazioneDto05 aggiorna(){
        System.out.println("Siamo in aggiorna");
        RegistrazioneDto05 rx = new RegistrazioneDto05();
        rx.setSessione("123stella");
        return rx;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.kezapp.controller;

import com.example.kezapp.model.RegistrazioneDto12;
import com.example.kezapp.model.RichiediRegistrazioneDto12;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author utente
 */
@RestController
public class KezappController12 {
    @RequestMapping(value = "/registrazione12")
    public RegistrazioneDto12 registrazione(){
        System.out.println("Siamo in registrazione12");
        RegistrazioneDto12 rx = new RegistrazioneDto12();
        rx.setSessione("registrazione");
        return rx;
    }
     @RequestMapping(value = "/inviaTutti12")
    public RegistrazioneDto12 inviatutti(){
        System.out.println("inviato a tutti ");
        RegistrazioneDto12 rx = new RegistrazioneDto12();
        rx.setSessione("invia a tutti");
        return rx;
    }
    @RequestMapping(value = "/inviaUno12")
    public RegistrazioneDto12 inviaUno(){
        System.out.println("inviato a tutti ");
        RegistrazioneDto12 rx = new RegistrazioneDto12();
        rx.setSessione("invia a uno");
        return rx;
    }
    @RequestMapping(value = "/aggiorna12")
    public RegistrazioneDto12 aggiorna(){
        System.out.println("aggiorna ");
        RegistrazioneDto12 rx = new RegistrazioneDto12();
        rx.setSessione("aggiorna");
        return rx;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.kezapp.controller;

import com.example.kezapp.model.RegistrazioneDto13;
import com.example.kezapp.model.RichiediRegistrazioneDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author utente
 */
@RestController
public class KezappController13 {
    @RequestMapping(value="/registrazione13")
    public RegistrazioneDto13 Registrazione(){
        System.out.println("Siamo in registrazione");
        RegistrazioneDto13 rx = new RegistrazioneDto13();
        rx.setSessione("Registrazione");
        return rx;
    }
    
    @RequestMapping(value="/inviatutti13")
    public RegistrazioneDto13 inviaTutti(){
        System.out.println("Invia il messaggio a tutti");
        RegistrazioneDto13 rx = new RegistrazioneDto13();
        rx.setSessione("Invia a tutti");
        return rx;
    }
    
    @RequestMapping(value="/inviauno13")
    public RegistrazioneDto13 inviaUno(){
        System.out.println("Invia il messaggio a un solo utente");
        RegistrazioneDto13 rx = new RegistrazioneDto13();
        rx.setSessione("Invia a uno");
        return rx;
    }
    
    @RequestMapping(value="/aggiorna13")
    public RegistrazioneDto13 aggiorna(){
        System.out.println("aggiornamento");
        RegistrazioneDto13 rx = new RegistrazioneDto13();
        rx.setSessione("Aggiornamento");
        return rx;
    }
}

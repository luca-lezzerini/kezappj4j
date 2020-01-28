/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.kezapp.controller;

import com.example.kezapp.model.RegistrazioneDto08;
import com.example.kezapp.model.RichiediRegistrazioneDto08;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author utente
 */
@RestController
public class KezappController08 {
    
    @RequestMapping(value = "/registrazione08")
    public RegistrazioneDto08 registrazione(){
        System.out.println("Siamo in registrazione!");
        RegistrazioneDto08 rx =new RegistrazioneDto08();
        rx.setSessione("123stella!");
        return rx;
    }
    
    @RequestMapping(value = "/inviaTutti08")
     public RegistrazioneDto08 inviaTutti08(){
        System.out.println("Siamo in Invia tutti!");
        RegistrazioneDto08 rx =new RegistrazioneDto08();
        rx.setSessione("123tutti!");
        return rx;
     }
    @RequestMapping(value = "/inviaUno08")
     public RegistrazioneDto08 inviaUno08(){
        System.out.println("Siamo in Invia uno!");
        RegistrazioneDto08 rx =new RegistrazioneDto08();
        rx.setSessione("123Uno!");
        return rx;
     }
 @RequestMapping(value = "/aggiorna08")
     public RegistrazioneDto08 aggiorna08(){
        System.out.println("Siamo in aggiorna!");
        RegistrazioneDto08 rx =new RegistrazioneDto08();
        rx.setSessione("123 aggiorna!");
        return rx;
     }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.kezapp.controller;

import com.example.kezapp.model.RegistrazioneDto03;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author utente
 */
@RestController
public class KezappController03 {

    /**
     *
     * @return
     */
    @RequestMapping (value = "/registrazione03")
    public RegistrazioneDto03 registrazione(){
    System.out.println("Siamo in registrazione!");
    return new RegistrazioneDto03();
    }
    
    @RequestMapping (value = "/inviaTutti03")
    public RegistrazioneDto03 InviaTutti(){
        System.out.println("Invia a tutti");
            return new RegistrazioneDto03();
            
    }
    
    @RequestMapping (value = "/inviaUno03")
    public RegistrazioneDto03 InviaUno(){
        System.out.println("Invia a uno");
            return new RegistrazioneDto03();
            
    }
            @RequestMapping (value = "/aggiorna03")
            public RegistrazioneDto03 aggiorna(){
            System.out.println("Aggiorna");
            return new RegistrazioneDto03();
    
    
    
    
}
 }

 
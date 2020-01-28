/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.kezapp.controller;

import com.example.kezapp.model.RegistrazioneDto17;
import com.example.kezapp.model.RichiediRegistrazioneDto17;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author utente
 */

@RestController
public class KezappController17 {
    
    @RequestMapping(value = "/registrazione17")
    public RegistrazioneDto17 registrazione(){
        System.out.println("Siamo in registrazione!");
        RegistrazioneDto17 rx = new RegistrazioneDto17();
        rx.setSessione("113stella");
        return new RegistrazioneDto17();
    }
    
//    public RegistrazioneDto17 inviaATutti(){
//        return null;
//    }
//    
//    public RegistrazioneDto17 inviaAUno(){
//        return null;
//    }
//    
//    public RegistrazioneDto17 aggiorna(){
//        return null;
//    }
}

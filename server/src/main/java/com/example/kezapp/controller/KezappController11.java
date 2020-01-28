/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.kezapp.controller;

import com.example.kezapp.model.InviaMessaggioDto11;
import com.example.kezapp.model.RegistrazioneDto11;
import com.example.kezapp.model.RichiediRegistrazioneDto11;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KezappController11 {

    @RequestMapping(value = "/registrazione11")
    public RegistrazioneDto11 registrazione() {
        System.out.println("Siamo in registrazione!");
        RegistrazioneDto11 rx = new RegistrazioneDto11();
        rx.setSessione("123 stella!");
        return rx;
    }

    @RequestMapping(value = "/inviatutti11")
    public RegistrazioneDto11 inviaTutti() {
        System.out.println("Invia a tutti!");
        RegistrazioneDto11 it = new RegistrazioneDto11();
        it.setSessione("1234 stella!");
        return it;
    }
    @RequestMapping(value = "/inviauno11")
    public RegistrazioneDto11 inviaUno(){
        System.out.println("Invia a uno");
        RegistrazioneDto11 im = new RegistrazioneDto11();
        im.setSessione("1235 stella!");
        return im;
    }
    
    @RequestMapping(value= "/aggiorna11")
    public RegistrazioneDto11 aggiorna(){
        System.out.println("Aggiorna");
        RegistrazioneDto11 ag = new RegistrazioneDto11();
        ag.setSessione("123456 stella!");
        return ag;
    }
}

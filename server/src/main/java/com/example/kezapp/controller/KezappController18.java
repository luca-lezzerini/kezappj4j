/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.kezapp.controller;

import com.example.kezapp.model.RegistrazioneDto18;
import com.example.kezapp.model.RichiediRegistrazioneDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author utente
 */
@RestController
public class KezappController18 {
    @RequestMapping(value = "/registrazione")
    public RegistrazioneDto18 registrazione ()  {
        System.out.println("Stiamo in registrazione");
        RegistrazioneDto18 rx= new RegistrazioneDto18();
        rx.setSessione("123stella");
        return rx;
    }
}

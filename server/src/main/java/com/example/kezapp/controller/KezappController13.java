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
    @RequestMapping(value="/registrazione")
    public RegistrazioneDto13 Registrazione(){
        System.out.println("Siamo in registrazione");
        return new RegistrazioneDto13();
    }
}

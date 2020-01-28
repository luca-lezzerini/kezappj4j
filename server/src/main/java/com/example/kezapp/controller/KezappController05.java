/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.kezapp.controller;

import com.example.kezapp.model.RegistrazioneDto05;
import com.example.kezapp.model.RichiediRegistrazioneDto05;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author utente
 */
@Controller
public class KezappController05 {
    @RequestMapping(value = "/registrazione")
    public RegistrazioneDto05 registrazione(){
        System.out.println("Siamo in registrazione");
        return new RegistrazioneDto05();
    }
}

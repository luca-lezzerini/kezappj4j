/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.kezapp.controller;

import com.example.kezapp.model.RegistrazioneDto01;
import com.example.kezapp.model.RichiediRegistrazioneDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KezappController01 {
    @RequestMapping(value = "/registrazione01")
    public RegistrazioneDto01 registrazione(){
        System.out.println("Siamo in registrazione");
        RegistrazioneDto01 rx = new RegistrazioneDto01();
        rx.setSessione("123Stella!");
        return rx;
    }
}

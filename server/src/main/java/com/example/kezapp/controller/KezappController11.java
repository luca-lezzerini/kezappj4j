/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.kezapp.controller;

import com.example.kezapp.model.RegistrazioneDto11;
import com.example.kezapp.model.RichiediRegistrazioneDto11;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class KezappController11 {
    @RequestMapping(value = "/registrazione11")
    public RegistrazioneDto11 registrazione(){
        System.out.println("Siamo in registrazione!");
        RegistrazioneDto11 rx = new RegistrazioneDto11();
        rx.setSessione("123 stella!");
        return rx;
    }
}

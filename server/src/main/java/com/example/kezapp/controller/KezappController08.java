/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.kezapp.controller;

import com.example.kezapp.model.Chat08;
import com.example.kezapp.model.InviaMessaggioDto08;
import com.example.kezapp.model.Messaggio08;
import com.example.kezapp.model.RegistrazioneDto08;
import com.example.kezapp.model.RichiediMessaggiDto08;
import com.example.kezapp.model.RichiediRegistrazioneDto08;
import com.example.kezapp.service.KezappService08;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author utente
 */
@CrossOrigin("*") // prihvati pagine generirane da qualsiasi server
@RestController
public class KezappController08 {
    @Autowired
    KezappService08 ss;

    @RequestMapping(value = "/registrazione08")
    @ResponseBody
    public RegistrazioneDto08 registrazione(@RequestBody RichiediRegistrazioneDto08 dto) {
        System.out.println("Siamo in registrazione!");

        return ss.registrazione(dto);
    }

    @RequestMapping(value = "/inviaUno08")
    @ResponseBody
    public RegistrazioneDto08 inviaUno(@RequestBody InviaMessaggioDto08 dto) {
        System.out.println("Siamo in inviaUno!");
        
        return ss.inviaUno(dto);
    }

    @RequestMapping(value = "/inviaTutti08")
    public RegistrazioneDto08 inviaTutti(@RequestBody InviaMessaggioDto08 dto) {
        System.out.println("Siamo in inviaTutti!");

        return ss.inviaTutti(dto);
    }

    @RequestMapping(value = "/aggiorna08")
    public RegistrazioneDto08 aggiorna(@RequestBody RichiediMessaggiDto08 dto) {
        System.out.println("Siamo in aggiorna!");
        
        return ss.aggiorna(dto);
    }

}

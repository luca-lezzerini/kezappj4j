/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.kezapp.controller;

import com.example.kezapp.model.Chat05;
import com.example.kezapp.model.InviaMessaggioDto05;
import com.example.kezapp.model.Messaggio05;
import com.example.kezapp.model.RegistrazioneDto05;
import com.example.kezapp.model.RichiediMessaggioDto05;
import com.example.kezapp.model.RichiediRegistrazioneDto05;
import com.example.kezapp.service.KezappService05;
import com.example.kezapp.service.impl.KezappServiceImpl05;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author utente
 */
@CrossOrigin("*")
@RestController
public class KezappController05 {
    
    @Autowired
    KezappService05 ss;
    
    @RequestMapping(value = "/registrazione05")
    @ResponseBody
    public RegistrazioneDto05 registrazione(@RequestBody RichiediRegistrazioneDto05 dto){
        System.out.println("Siamo in registrazione");
        return ss.registrazione(dto);
    }
              
    @RequestMapping(value = "/inviatutti05")
    public RegistrazioneDto05 inviaTutti(@RequestBody InviaMessaggioDto05 dto){
        System.out.println("Siamo in invia a tutti");
        return ss.inviaTutti(dto);
        }
    
    @RequestMapping(value = "/aggiorna05")
    public RegistrazioneDto05 aggiorna(@RequestBody RichiediMessaggioDto05 dto){
        System.out.println("Siamo in aggiorna");
        return ss.aggiorna(dto);
    }
    
    @RequestMapping(value = "/inviauno05")
    public RegistrazioneDto05 inviauno(@RequestBody InviaMessaggioDto05 dto){
        System.out.println("Siamo in inviauno");
        return ss.inviaUno(dto);
    }   
}

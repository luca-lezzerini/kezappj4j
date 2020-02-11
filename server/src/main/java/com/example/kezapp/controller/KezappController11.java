/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.kezapp.controller;

import com.example.kezapp.model.Chat11;
import com.example.kezapp.model.InviaMessaggioDto11;
import com.example.kezapp.model.Messaggio11;
import com.example.kezapp.model.RegistrazioneDto11;
import com.example.kezapp.model.RichiediMessaggiDto11;
import com.example.kezapp.model.RichiediRegistrazioneDto;
import com.example.kezapp.model.RichiediRegistrazioneDto11;
import com.example.kezapp.service.KezappService11;
import com.example.kezapp.service.impl.KezappServiceImpl11;
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

@CrossOrigin("*")
@RestController
public class KezappController11 {
    
    @Autowired
    KezappService11 ss;

    @RequestMapping(value = "/registrazione11")
    @ResponseBody
    public RegistrazioneDto11 registrazione(@RequestBody RichiediRegistrazioneDto dto) {
        System.out.println("Siamo in registrazione!");
        
        return ss.registrazione(dto);
    }

    @RequestMapping(value = "/inviaUno11")
    @ResponseBody
    public RegistrazioneDto11 inviaUno(@RequestBody InviaMessaggioDto11 dto) {
        System.out.println("Siamo in inviaUno!");
       
        return ss.inviaUno(dto);
    }
    
    @RequestMapping(value = "/inviaTutti11")
    
    public RegistrazioneDto11 inviaTutti(@RequestBody InviaMessaggioDto11 dto){
        System.out.println("Invia a tutti!");
        
        return ss.inviaTutti(dto);
        
    }
    
    @RequestMapping(value= "/aggiorna11")
    public RegistrazioneDto11 aggiorna(@RequestBody RichiediMessaggiDto11 dto){
        System.out.println("Aggiorna");
        
        return ss.aggiorna(dto);
    }
}

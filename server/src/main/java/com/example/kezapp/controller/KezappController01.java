package com.example.kezapp.controller;

import com.example.kezapp.model.Chat00;
import com.example.kezapp.model.Chat01;
import com.example.kezapp.model.InviaMessaggioDto00;
import com.example.kezapp.model.InviaMessaggioDto01;
import com.example.kezapp.model.Messaggio00;
import com.example.kezapp.model.Messaggio01;
import com.example.kezapp.model.RegistrazioneDto00;
import com.example.kezapp.model.RegistrazioneDto01;
import com.example.kezapp.model.RichiediMessaggiDto01;
import com.example.kezapp.model.RichiediRegistrazioneDto;
import com.example.kezapp.service.KezappService01;
import com.example.kezapp.service.impl.KezappServiceImpl01;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class KezappController01 {
    
    @Autowired
    KezappService01 ss;

    @RequestMapping(value = "/registrazione01")
    @ResponseBody
    public RegistrazioneDto01 registrazione(@RequestBody RichiediRegistrazioneDto dto) {
        System.out.println("Siamo in registrazione!");
        return ss.registrazione(dto);
    }
    
    @RequestMapping(value = "/inviaUno01")
    @ResponseBody
    public RegistrazioneDto01 inviaUno(@RequestBody InviaMessaggioDto01 dto) {
        System.out.println("Siamo in inviaUno!");       
        return ss.inviaUno(dto);
    }

    @RequestMapping(value = "/inviaTutti01")
    public RegistrazioneDto01 inviaTutti(@RequestBody InviaMessaggioDto01 dto) {
        System.out.println("Siamo in inviaTutti!");
        
        return ss.inviaTutti(dto);
    }

    @RequestMapping(value = "/aggiorna01")
    public RegistrazioneDto01 aggiorna(@RequestBody RichiediMessaggiDto01 dto) {
        System.out.println("siamo in aggiorna"); 
        
        return ss.aggiorna(dto);
    }
    
    
    
}

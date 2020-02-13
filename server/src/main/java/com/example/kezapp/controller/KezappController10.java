package com.example.kezapp.controller;

import com.example.kezapp.model.InviaMessaggioDto10;
import com.example.kezapp.model.RegistrazioneDto10;
import com.example.kezapp.model.RichiediMessaggiDto10;
import com.example.kezapp.model.RichiediRegistrazioneDto10;
import com.example.kezapp.service.KezappService10;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class KezappController10 {
    
    @Autowired
    KezappService10 ss;
    
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
//////////////////////////////REGISTRAZIONE//////////////////////////////////////////////////////////////////////////////////////////    
    
    @RequestMapping(value = "/registrazione10")
    @ResponseBody
    public RegistrazioneDto10 registrazione(@RequestBody RichiediRegistrazioneDto10 dto){
        
        System.out.println("Siamo in registrazione!");
        return ss.registrazione(dto);
    }
    
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////INVIA A TUTTI///////////////////////////////////////////////////////////////////////////////////////////
    
    @RequestMapping(value = "/inviatutti10")
    @ResponseBody
    public RegistrazioneDto10 inviaTutti(@RequestBody InviaMessaggioDto10 dto){
        System.out.println("Siamo in Invia Tutti!");
        return ss.inviaTutti(dto);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
/////////////////////////////INVIA A UNO///////////////////////////////////////////////////////////////////////////////////////////
    
    @RequestMapping(value = "/inviauno10")
    @ResponseBody
    public RegistrazioneDto10 inviaUno(@RequestBody InviaMessaggioDto10 dto){
        System.out.println("Siamo in Invia Tutti!");
        return ss.inviaUno(dto);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
///////////////////////////////AGGIORNA//////////////////////////////////////////////////////////////////////////////////////////////
    
    @RequestMapping(value = "/aggiorna10")
    @ResponseBody
    public RegistrazioneDto10 aggiorna(@RequestBody RichiediMessaggiDto10 dto){
        System.out.println("Siamo in aggiorna!");
        return ss.aggiorna(dto);
        }    
}
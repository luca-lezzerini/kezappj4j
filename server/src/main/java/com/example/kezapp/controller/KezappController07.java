
package com.example.kezapp.controller;

import com.example.kezapp.model.Chat07;
import com.example.kezapp.model.InviaMessaggioDto07;
import com.example.kezapp.model.Messaggio07;
import com.example.kezapp.model.RegistrazioneDto07;
import com.example.kezapp.model.RichiediMessaggioDto07;
import com.example.kezapp.model.RichiediRegistrazioneDto07;
import com.example.kezapp.service.KezappService07;
import com.example.kezapp.service.impl.KezappServiceImpl07;
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
public class KezappController07{
    @Autowired
    KezappService07 ss;
    @RequestMapping(value = "/registrazione07")
    @ResponseBody
    public RegistrazioneDto07 registrazione(@RequestBody RichiediRegistrazioneDto07 dto){
        System.out.println("siamo in registrazione :)");
        
        return ss.registrazione(dto);
    }
    /////////////////////////////////////////////
    //invia a tutti
    ////////////////////////////////////////////
    @RequestMapping(value = "/inviaATutti07")
    @ResponseBody
    public RegistrazioneDto07 inviaTutti(@RequestBody InviaMessaggioDto07 dto){
        return ss.inviaTutti(dto);
    }
    ///////////////////////////////////////////////
    //invia a uno
    ////////////////////////////////////////////////
    @RequestMapping(value = "/inviaUno07")
    @ResponseBody
    public RegistrazioneDto07 inviaUno(@RequestBody InviaMessaggioDto07 dto){
        return ss.inviaUno(dto);
    }
    //aggiorna
    @RequestMapping(value = "/aggiorna07")
    @ResponseBody
    public RegistrazioneDto07 aggiorna(@RequestBody RichiediMessaggioDto07 dto){
        return ss.aggiorna(dto);
    }
}

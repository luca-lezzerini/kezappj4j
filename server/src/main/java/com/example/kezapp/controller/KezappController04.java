package com.example.kezapp.controller;

import com.example.kezapp.model.InviaMessaggioDto04;
import com.example.kezapp.model.RegistrazioneDto04;
import com.example.kezapp.model.RichiediMessaggiDto04;
import com.example.kezapp.model.RichiediRegistrazioneDto04;
import com.example.kezapp.service.KezappService04;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class KezappController04 {

    @Autowired
    KezappService04 kezappService04;

    @RequestMapping(value = "/registrazione04")
    @ResponseBody
    public RegistrazioneDto04 registrazione(@RequestBody RichiediRegistrazioneDto04 dto) {
        System.out.println("Siamo in registrazione!");
        return kezappService04.registrazione(dto);
    }

    @RequestMapping(value = "/inviaTutti04")
    public RegistrazioneDto04 inviaTutti(@RequestBody InviaMessaggioDto04 dto) {
        System.out.println("Siamo in inviaTutti!");
        return kezappService04.inviaTutti(dto);
    }

    @RequestMapping(value = "/inviaUno04")
    public RegistrazioneDto04 inviaUno(@RequestBody InviaMessaggioDto04 dto) {
        System.out.println("Siamo in inviaUno!");
        return kezappService04.inviaUno(dto);
    }

    @RequestMapping(value = "/aggiorna04")
    public RegistrazioneDto04 aggiorna(@RequestBody RichiediMessaggiDto04 dto) {
        System.out.println("Siamo in aggiorna!");
        return kezappService04.aggiorna(dto);
    }

    
}

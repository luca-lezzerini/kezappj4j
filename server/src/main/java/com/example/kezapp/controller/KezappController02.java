package com.example.kezapp.controller;

import com.example.kezapp.model.InviaMessaggioDto02;
import com.example.kezapp.model.RegistrazioneDto02;
import com.example.kezapp.model.RichiediMessaggioDto02;
import com.example.kezapp.model.RichiediRegistrazioneDto;
import com.example.kezapp.service.KezappService02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class KezappController02 {
    
    @Autowired
    KezappService02 ss;
    
    @RequestMapping(value = "/registrazione02")
    @ResponseBody
    public RegistrazioneDto02 registrazione(@RequestBody RichiediRegistrazioneDto dto) {
        System.out.println("Siamo in registrazione!");
        return ss.registrazione(dto);
    }

    @RequestMapping(value = "/inviaTutti02")
    @ResponseBody
    public RegistrazioneDto02 inviaTutti(@RequestBody InviaMessaggioDto02 dto) {
        System.out.println("Siamo in inviaTutti!");
        return ss.inviaTutti(dto);
    }

    @RequestMapping(value = "/inviaUno02")
    @ResponseBody
    public RegistrazioneDto02 inviaUno(@RequestBody InviaMessaggioDto02 dto) {
        System.out.println("Siamo in inviaUno!");
        return ss.inviaUno(dto);
    }

    @RequestMapping(value = "/aggiorna02")
    @ResponseBody
    public RegistrazioneDto02 aggiorna(@RequestBody RichiediMessaggioDto02 dto) {
        System.out.println("Siamo in aggiorna!");
        return ss.aggiorna(dto);
    }
}

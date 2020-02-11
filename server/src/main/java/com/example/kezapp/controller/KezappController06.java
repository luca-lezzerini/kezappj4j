package com.example.kezapp.controller;

import com.example.kezapp.model.*;
import com.example.kezapp.service.KezappService06;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class KezappController06 {

    @Autowired
    KezappService06 ss;

    @RequestMapping(value = "/registrazione06")
    @ResponseBody
    public RegistrazioneDto06 registrazione(@RequestBody RichiediRegistrazioneDto06 dto) {
        System.out.println("Registrazione");
        return ss.registrazione(dto);
    }

    @RequestMapping(value = "/invia-tutti06")
    @ResponseBody
    public RegistrazioneDto06 inviaTutti(@RequestBody InviaMessaggioDto06 dto) {
        System.out.println("Invia a tutti");
        return ss.inviaTutti(dto);
    }

    @RequestMapping(value = "/invia06")
    @ResponseBody
    public RegistrazioneDto06 inviaUno(@RequestBody InviaMessaggioDto06 dto) {
        System.out.println("Inviato a una persona");
        return ss.inviaUno(dto);
    }

    @RequestMapping(value = "/aggiorna06")
    @ResponseBody
    public RegistrazioneDto06 aggiorna(@RequestBody RichiediMessaggiDto06 dto) {
        System.out.println("Aggiornamento");
        return ss.aggiorna(dto);
    }
}

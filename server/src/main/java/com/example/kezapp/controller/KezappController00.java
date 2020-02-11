package com.example.kezapp.controller;

import com.example.kezapp.model.Chat00;
import com.example.kezapp.model.InviaMessaggioDto00;
import com.example.kezapp.model.Messaggio00;
import com.example.kezapp.model.RegistrazioneDto00;
import com.example.kezapp.model.RichiediMessaggioDto00;
import com.example.kezapp.model.RichiediRegistrazioneDto;
import com.example.kezapp.service.KezappService00;
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
public class KezappController00 {

    @Autowired
    KezappService00 ss;

    @RequestMapping(value = "/registrazione00")
    @ResponseBody
    public RegistrazioneDto00 registrazione(@RequestBody RichiediRegistrazioneDto dto) {
        System.out.println("Siamo in registrazione!");

        return ss.registrazione(dto);
    }

    @RequestMapping(value = "/inviaUno00")
    @ResponseBody
    public RegistrazioneDto00 inviaUno(@RequestBody InviaMessaggioDto00 dto) {
        System.out.println("Siamo in inviaUno!");
        
        return ss.inviaUno(dto);
    }

    @RequestMapping(value = "/inviaTutti00")
    public RegistrazioneDto00 inviaTutti(@RequestBody InviaMessaggioDto00 dto) {
        System.out.println("Siamo in inviaTutti!");

        return ss.inviaTutti(dto);
    }

    @RequestMapping(value = "/aggiorna00")
    public RegistrazioneDto00 aggiorna(@RequestBody RichiediMessaggioDto00 dto) {
        System.out.println("Siamo in aggiorna!");
        
        return ss.aggiorna(dto);
    }

}


package com.example.kezapp.controller;

import com.example.kezapp.model.Chat17;
import com.example.kezapp.model.InviaMessaggioDto17;
import com.example.kezapp.model.Messaggio17;
import com.example.kezapp.model.RegistrazioneDto17;
import com.example.kezapp.model.RichiediMessaggioDto17;
import com.example.kezapp.model.RichiediRegistrazioneDto17;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.kezapp.service.impl.KezappServiceImpl17;
import com.example.kezapp.service.KezappService17;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alessandro G.
 */

@CrossOrigin("*")
@RestController
public class KezappController17 {
    
    @Autowired
    KezappService17 ss;
    
    @RequestMapping(value = "/registrazione17")
    @ResponseBody
    public RegistrazioneDto17 registrazione(@RequestBody RichiediRegistrazioneDto17 dto){
        System.out.println("Siamo in registrazione!");

        return ss.registrazione(dto);
    }
    
    @RequestMapping(value = "/inviatutti17")
    public RegistrazioneDto17 inviaTutti(@RequestBody InviaMessaggioDto17 dto){
        System.out.println("Siamo in inviaATutti!");
        
        return ss.inviaTutti(dto);
    }
    
    @RequestMapping(value = "/inviauno17")
    @ResponseBody
    public RegistrazioneDto17 inviaUno(@RequestBody InviaMessaggioDto17 dto){
        System.out.println("Siamo in inviaAUno!");

        return ss.inviaUno(dto);
    }
    
    @RequestMapping(value = "/aggiorna17")
    public RegistrazioneDto17 aggiorna(@RequestBody RichiediMessaggioDto17 dto){
        System.out.println("Siamo in aggiorna!");
        
        return ss.aggiorna(dto);
    }
}

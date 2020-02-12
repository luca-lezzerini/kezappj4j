/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.kezapp.service;

import com.example.kezapp.model.InviaMessaggioDto17;
import com.example.kezapp.model.RegistrazioneDto17;
import com.example.kezapp.model.RichiediMessaggioDto17;
import com.example.kezapp.model.RichiediRegistrazioneDto17;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author utente
 */
public interface KezappService17 {
    
    RegistrazioneDto17 registrazione(RichiediRegistrazioneDto17 dto);
    
    RegistrazioneDto17 inviaTutti(InviaMessaggioDto17 dto);
    
    RegistrazioneDto17 inviaUno(InviaMessaggioDto17 dto);
    
    RegistrazioneDto17 aggiorna(RichiediMessaggioDto17 dto);
}

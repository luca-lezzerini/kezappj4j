/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.kezapp.service;

import com.example.kezapp.model.InviaMessaggioDto11;
import com.example.kezapp.model.RegistrazioneDto11;
import com.example.kezapp.model.RichiediMessaggiDto11;
import com.example.kezapp.model.RichiediRegistrazioneDto;
import com.example.kezapp.model.RichiediRegistrazioneDto11;

/**
 *
 * @author utente
 */
public interface KezappService11 {
    
    RegistrazioneDto11 registrazione(RichiediRegistrazioneDto dto);
    
    RegistrazioneDto11 inviaTutti(InviaMessaggioDto11 dto);
    
    RegistrazioneDto11 inviaUno (InviaMessaggioDto11 dto);
    
    RegistrazioneDto11 aggiorna(RichiediMessaggiDto11 dto);
    
}

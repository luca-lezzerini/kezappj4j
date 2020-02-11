/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.kezapp.service;

import com.example.kezapp.model.InviaMessaggioDto05;
import com.example.kezapp.model.RegistrazioneDto05;
import com.example.kezapp.model.RichiediMessaggioDto05;
import com.example.kezapp.model.RichiediRegistrazioneDto05;

/**
 *
 * @author utente
 */
public interface KezappService05 {
    public RegistrazioneDto05 registrazione(RichiediRegistrazioneDto05 dto);
    public RegistrazioneDto05 inviaTutti( InviaMessaggioDto05 dto);
    public RegistrazioneDto05 aggiorna(RichiediMessaggioDto05 dto);
    public RegistrazioneDto05 inviaUno(InviaMessaggioDto05 dto);
}

package com.example.kezapp.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.example.kezapp.model.InviaMessaggioDto08;
import com.example.kezapp.model.RegistrazioneDto08;
import com.example.kezapp.model.RichiediMessaggiDto08;
import com.example.kezapp.model.RichiediRegistrazioneDto08;

public interface KezappService08 {

     RegistrazioneDto08 registrazione(RichiediRegistrazioneDto08 dto);

    RegistrazioneDto08 inviaTutti(InviaMessaggioDto08 dto);

    RegistrazioneDto08 aggiorna(RichiediMessaggiDto08 dto);

    RegistrazioneDto08 inviaUno(InviaMessaggioDto08 dto);
}

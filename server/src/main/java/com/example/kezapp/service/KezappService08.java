package com.example.kezapp.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.example.kezapp.model.InviaMessaggioDto08;
import com.example.kezapp.model.RegistrazioneDto08;
import com.example.kezapp.model.RichiediMessaggioDto08;
import com.example.kezapp.model.RichiediRegistrazioneDto;

public interface KezappService08 {

    RegistrazioneDto08 registrazione(RichiediRegistrazioneDto dto);

    RegistrazioneDto08 inviaTutti(InviaMessaggioDto08 dto);

    RegistrazioneDto08 aggiorna(RichiediMessaggioDto08 dto);
}

package com.example.kezapp.service;

import com.example.kezapp.model.InviaMessaggioDto02;
import com.example.kezapp.model.RegistrazioneDto02;
import com.example.kezapp.model.RichiediMessaggioDto02;
import com.example.kezapp.model.RichiediRegistrazioneDto;

public interface KezappService02 {
    RegistrazioneDto02 registrazione(RichiediRegistrazioneDto dto);
    RegistrazioneDto02 inviaTutti(InviaMessaggioDto02 dto);
    RegistrazioneDto02 aggiorna(RichiediMessaggioDto02 dto);
    RegistrazioneDto02 inviaUno(InviaMessaggioDto02 dto);
}

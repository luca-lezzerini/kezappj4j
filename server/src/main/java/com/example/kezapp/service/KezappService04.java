package com.example.kezapp.service;

import com.example.kezapp.model.InviaMessaggioDto04;
import com.example.kezapp.model.RegistrazioneDto04;
import com.example.kezapp.model.RichiediMessaggiDto04;
import com.example.kezapp.model.RichiediRegistrazioneDto04;

public interface KezappService04 {

    RegistrazioneDto04 registrazione(RichiediRegistrazioneDto04 dto);

    RegistrazioneDto04 inviaTutti(InviaMessaggioDto04 dto);

    RegistrazioneDto04 aggiorna(RichiediMessaggiDto04 dto);
    
    RegistrazioneDto04 inviaUno(InviaMessaggioDto04 dto);
}

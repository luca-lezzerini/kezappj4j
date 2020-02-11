package com.example.kezapp.service;

import com.example.kezapp.model.InviaMessaggioDto10;
import com.example.kezapp.model.RegistrazioneDto10;
import com.example.kezapp.model.RichiediMessaggiDto10;
import com.example.kezapp.model.RichiediRegistrazioneDto10;

public interface KezappService10 {
       RegistrazioneDto10 registrazione( RichiediRegistrazioneDto10 dto);
       RegistrazioneDto10 inviaTutti( InviaMessaggioDto10 dto);
       RegistrazioneDto10 aggiorna( RichiediMessaggiDto10 dto);
       RegistrazioneDto10 inviaUno( InviaMessaggioDto10 dto);
}

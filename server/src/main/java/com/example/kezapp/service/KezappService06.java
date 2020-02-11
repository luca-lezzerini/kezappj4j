package com.example.kezapp.service;

import com.example.kezapp.model.*;

public interface KezappService06 {

    public RegistrazioneDto06 registrazione(RichiediRegistrazioneDto06 dto);
    
    public RegistrazioneDto06 inviaTutti(InviaMessaggioDto06 dto);
    
    public RegistrazioneDto06 inviaUno(InviaMessaggioDto06 dto);

    public RegistrazioneDto06 aggiorna(RichiediMessaggiDto06 dto);
    
    
}

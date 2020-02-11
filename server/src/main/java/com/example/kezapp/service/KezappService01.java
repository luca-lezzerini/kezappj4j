
package com.example.kezapp.service;

import com.example.kezapp.model.Chat01;
import com.example.kezapp.model.InviaMessaggioDto01;
import com.example.kezapp.model.RegistrazioneDto01;
import com.example.kezapp.model.RichiediMessaggiDto01;
import com.example.kezapp.model.RichiediRegistrazioneDto;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;



public interface KezappService01 {
    RegistrazioneDto01 registrazione(RichiediRegistrazioneDto dto);
    
    public RegistrazioneDto01 inviaTutti(InviaMessaggioDto01 dto);
    
    RegistrazioneDto01 aggiorna(RichiediMessaggiDto01 dto);
    
    RegistrazioneDto01 inviaUno(InviaMessaggioDto01 dto);
}


package com.example.kezapp.service;

import com.example.kezapp.model.InviaMessaggioDto07;
import com.example.kezapp.model.RegistrazioneDto07;
import com.example.kezapp.model.RichiediMessaggioDto07;
import com.example.kezapp.model.RichiediRegistrazioneDto07;
import org.springframework.web.bind.annotation.RequestBody;


public interface KezappService07 {
       RegistrazioneDto07 registrazione( RichiediRegistrazioneDto07 dto);
       RegistrazioneDto07 inviaTutti( InviaMessaggioDto07 dto);
       RegistrazioneDto07 aggiorna( RichiediMessaggioDto07 dto);
       RegistrazioneDto07 inviaUno( InviaMessaggioDto07 dto);
       
     
}

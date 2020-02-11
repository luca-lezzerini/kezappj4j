package com.example.kezapp.service;

import com.example.kezapp.model.InviaMessaggioDto00;
import com.example.kezapp.model.RegistrazioneDto00;
import com.example.kezapp.model.RichiediMessaggioDto00;
import com.example.kezapp.model.RichiediRegistrazioneDto;
import org.springframework.web.bind.annotation.RequestBody;

public interface KezappService00 {

    RegistrazioneDto00 registrazione(RichiediRegistrazioneDto dto);

    RegistrazioneDto00 inviaTutti(InviaMessaggioDto00 dto);

    RegistrazioneDto00 aggiorna(RichiediMessaggioDto00 dto);

    RegistrazioneDto00 inviaUno(InviaMessaggioDto00 dto);
}

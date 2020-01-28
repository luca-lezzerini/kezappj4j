
package com.example.kezapp.controller;

import com.example.kezapp.model.RegistrazioneDto07;
import com.example.kezapp.model.RichiediRegistrazioneDto07;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KezappController07 {
    @RequestMapping(value = "/registrazione07")
    public RegistrazioneDto07 registrazione(){
        System.out.println("siamo in registrazione :)");
        RegistrazioneDto07 rx = new RegistrazioneDto07();
        rx.setSessione("123stella");
        return rx;
    }
}

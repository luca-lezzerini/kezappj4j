package com.example.kezapp.controller;

import com.example.kezapp.model.Chat00;
import com.example.kezapp.model.Messaggio00;
import com.example.kezapp.model.RegistrazioneDto00;
import com.example.kezapp.model.RichiediRegistrazioneDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class KezappController00 {

    List<Chat00> chats = new ArrayList<>();
    List<Messaggio00> msgs = new ArrayList<>();

    @RequestMapping(value = "/registrazione00")
    @ResponseBody
    public RegistrazioneDto00 registrazione(@RequestBody RichiediRegistrazioneDto dto) {
        System.out.println("Siamo in registrazione!");

        // verifico se già esiste il nick-name
        boolean trovato = false;
        for (Chat00 chat : chats) {
            if (chat.getNickname().equalsIgnoreCase(dto.getNickname())) {
                trovato = true;
                break;
            }
        }

        // preparo la variabile per la risposta
        RegistrazioneDto00 rx = new RegistrazioneDto00();

        // se non esiste lo creo e lo aggiungo alla lista dei contatti
        if (!trovato) {
            Chat00 cx = new Chat00();
            cx.setNickname(dto.getNickname());
            // genero la sessione (non verifico se già esiste FIXME)
            double d = Math.random();
            cx.setSessione(Double.toString(d));
            chats.add(cx);
            
            rx.setContatti(chats);
            rx.setSessione(cx.getSessione());
            rx.setMessaggi(msgs);
        } else {
            // se esiste non aggiungo nulla e ritorno campi vuoti
            // perché non è ammesso il riuso del nickname
            rx.setContatti(new ArrayList<>());
            rx.setSessione(null);
            rx.setMessaggi(new ArrayList<>());
        }

        return rx;
    }

    @RequestMapping(value = "/inviaTutti00")
    public RegistrazioneDto00 inviaTutti() {
        System.out.println("Siamo in inviaTutti!");
        RegistrazioneDto00 rx = new RegistrazioneDto00();
        rx.setSessione("123stella!");
        return rx;
    }

    @RequestMapping(value = "/inviaUno00")
    public RegistrazioneDto00 inviaUno() {
        System.out.println("Siamo in inviaUno!");
        RegistrazioneDto00 rx = new RegistrazioneDto00();
        rx.setSessione("123stella!");
        return rx;
    }

    @RequestMapping(value = "/aggiorna00")
    public RegistrazioneDto00 aggiorna() {
        System.out.println("Siamo in aggiorna!");
        RegistrazioneDto00 rx = new RegistrazioneDto00();
        rx.setSessione("123stella!");
        return rx;
    }

}

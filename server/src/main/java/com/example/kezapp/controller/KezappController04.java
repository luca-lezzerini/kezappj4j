package com.example.kezapp.controller;

import com.example.kezapp.model.Chat04;
import com.example.kezapp.model.Messaggio04;
import com.example.kezapp.model.RegistrazioneDto04;
import com.example.kezapp.model.RichiediRegistrazioneDto04;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class KezappController04 {

    List<Chat04> chats = new ArrayList<>();
    List<Messaggio04> msgs = new ArrayList<>();

    @RequestMapping(value = "/registrazione04")
    @ResponseBody
    public RegistrazioneDto04 registrazione(@RequestBody RichiediRegistrazioneDto04 dto) {

        System.out.println("Siamo in registrazione!");

        boolean trovato = false;
        for (Chat04 chat : chats) {
            if (chat.getNickname().equalsIgnoreCase(dto.getNickname())) {
                trovato = true;
                break;
            }
        }

        RegistrazioneDto04 rx = new RegistrazioneDto04();

        if (!trovato) {
            Chat04 cx = new Chat04();
            cx.setNickname(dto.getNickname());
            cx.setSessione(Double.toString(Math.random()));
            chats.add(cx);
            rx.setContatti(chats);
            rx.setMessaggi(msgs);
            rx.setSessione(cx.getSessione());
        } else {
            rx.setContatti(new ArrayList<>());
            rx.setMessaggi(new ArrayList<>());
            rx.setSessione(null);
        }

        return rx;
    }

    @RequestMapping(value = "/inviaTutti04")
    public RegistrazioneDto04 inviaTutti() {

        System.out.println("Siamo in inviaTutti!");
        RegistrazioneDto04 rx = new RegistrazioneDto04();
        return rx;
    }

    @RequestMapping(value = "/inviaUno04")
    public RegistrazioneDto04 inviaUno() {
        System.out.println("Siamo in inviaUno!");
        return new RegistrazioneDto04();
    }

    @RequestMapping(value = "/aggiorna04")
    public RegistrazioneDto04 aggiorna() {
        System.out.println("Siamo in aggiorna!");
        return new RegistrazioneDto04();
    }
}

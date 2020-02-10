package com.example.kezapp.controller;

import com.example.kezapp.model.Chat04;
import com.example.kezapp.model.InviaMessaggioDto04;
import com.example.kezapp.model.Messaggio04;
import com.example.kezapp.model.RegistrazioneDto04;
import com.example.kezapp.model.RichiediRegistrazioneDto04;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class KezappController04 {

    private List<Chat04> chats = new ArrayList<>();
    private List<Messaggio04> msgs = new ArrayList<>();

    private List<Chat04> getChatsExceptPersonal(String sessione) {
        return chats
                .parallelStream()
                .filter(c -> !c.getSessione().equals(sessione))
                .collect(Collectors.toList());
    }

    private List<Messaggio04> getMsgsExceptPersonal(Chat04 chatTrovataFinal) {
        return msgs
                .parallelStream()
                .filter(m -> !m.getAliasMittente().equals(chatTrovataFinal.getNickname()))
                .collect(Collectors.toList());
    }

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
            rx.setContatti(getChatsExceptPersonal(cx.getSessione()));
            rx.setMessaggi(msgs);
            rx.setSessione(cx.getSessione());
        } else {
            rx.setContatti(Collections.emptyList());
            rx.setMessaggi(Collections.emptyList());
        }

        return rx;
    }

    @RequestMapping(value = "/inviaTutti04")
    public RegistrazioneDto04 inviaTutti(@RequestBody InviaMessaggioDto04 dto) {
        System.out.println("Siamo in inviaTutti!");

        //cerco se esiste la sessione ...
        boolean trovato = false;
        Chat04 chatTrovata = null;
        for (Chat04 chat : chats) {
            if (chat.getSessione().equals(dto.getSessione())) {
                chatTrovata = chat;
                trovato = true;
                break;
            }
        }

        RegistrazioneDto04 rx = new RegistrazioneDto04();
        //... se esiste aggiungo un msgso e ritorno pieno
        if (trovato) {
            Messaggio04 msg = new Messaggio04();
            msg.setAliasDestinatario(null);
            msg.setAliasMittente(chatTrovata.getNickname());
            msg.setTesto(dto.getMessaggio());
            msgs.add(msg);
            rx.setContatti(getChatsExceptPersonal(dto.getSessione()));
            Chat04 chatTrovataFinal = chatTrovata;
            rx.setMessaggi(getMsgsExceptPersonal(chatTrovataFinal));
        } //... se non esiste aggiungo bulla e ritorno vuoto
        else {
            rx.setContatti(Collections.emptyList());
            rx.setMessaggi(Collections.emptyList());
        }

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

package com.example.kezapp.controller;

import com.example.kezapp.model.Chat00;
import com.example.kezapp.model.Chat01;
import com.example.kezapp.model.InviaMessaggioDto00;
import com.example.kezapp.model.InviaMessaggioDto01;
import com.example.kezapp.model.Messaggio00;
import com.example.kezapp.model.Messaggio01;
import com.example.kezapp.model.RegistrazioneDto00;
import com.example.kezapp.model.RegistrazioneDto01;
import com.example.kezapp.model.RichiediRegistrazioneDto;
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
public class KezappController01 {

    List<Chat01> chats = new ArrayList<>();
    List<Messaggio01> msgs = new ArrayList<>();

    @RequestMapping(value = "/registrazione01")
    @ResponseBody
    public RegistrazioneDto01 registrazione(@RequestBody RichiediRegistrazioneDto dto) {
        System.out.println("Siamo in registrazione!");

        // verifico se già esiste il nick-name
        boolean trovato = false;
        for (Chat01 chat : chats) {
            if (chat.getNickname().equalsIgnoreCase(dto.getNickname())) {
                trovato = true;
                break;
            }
        }

        // preparo la variabile per la risposta
        RegistrazioneDto01 rx = new RegistrazioneDto01();

        // se non esiste lo creo e lo aggiungo alla lista dei contatti
        if (!trovato) {
            Chat01 cx = new Chat01();
            cx.setNickname(dto.getNickname());
            // genero la sessione (non verifico se già esiste FIXME)
            double d = Math.random();
            cx.setSessione(Double.toString(d));
            chats.add(cx);

            rx.setContatti(chats);
            rx.setSessione(cx.getSessione());
            rx.setMessaggio(msgs);
        } else {
            // se esiste non aggiungo nulla e ritorno campi vuoti
            // perché non è ammesso il riuso del nickname
            rx.setContatti(new ArrayList<>());
            rx.setSessione(null);
            rx.setMessaggio(new ArrayList<>());
        }

        return rx;
    }

    @RequestMapping(value = "/inviaUno01")
    @ResponseBody
    public RegistrazioneDto01 inviaUno(@RequestBody InviaMessaggioDto01 dto) {
        System.out.println("Siamo in inviaUno!");
        RegistrazioneDto01 rx = new RegistrazioneDto01();
        rx.setSessione("123stella!");
        return rx;
    }

    @RequestMapping(value = "/inviaTutti01")
    public RegistrazioneDto01 inviaTutti(@RequestBody InviaMessaggioDto01 dto) {
        System.out.println("Siamo in inviaTutti!");
        // cerco se esiste la sessione ...
        boolean trovato = false;
        Chat01 cx = null;
        for (Chat01 chat : chats) {
            if (chat.getSessione().equalsIgnoreCase(dto.getSessione())) {
                trovato = true;
                cx = chat;
                break;
            }
        }
        
        trovato = chats.stream().filter(x -> x.getSessione().equalsIgnoreCase(dto.getSessione())).count() >0;
        
        RegistrazioneDto01 rx = new RegistrazioneDto01();

        // ... se esiste aggiungo un messaggio e ritorno pieno
        if (trovato) {
            // creo nuovo messaggio
            Messaggio01 msg = new Messaggio01();
            msg.setTesto(dto.getMessaggio());
            msg.setAliasMittente(cx.getNickname());
            msg.setAliasDestinatario(null);

            // aggiungo un messaggio alla lista dei messaggi
            msgs.add(msg);
            
            // ritorno i contatti
            List<Chat01> listaContatti = chats.parallelStream()
                    .filter(c -> !(c.getSessione().equals(dto.getSessione())))
                    .collect(Collectors.toList());
            // ritorno i messaggi
            Chat01 cy = cx;
            List<Messaggio01> listaMessaggi = msgs.parallelStream()
                    .filter( m -> !(m.getAliasMittente().equals(cy.getNickname())))
                    .collect(Collectors.toList());
            rx.setContatti(listaContatti);
            rx.setMessaggio(listaMessaggi);
        } else {
            // ... se non esiste non aggiungo nulla e ritorno vuoto
            rx.setContatti(Collections.emptyList());
            rx.setMessaggio(Collections.emptyList());
        }
        return rx;
    }

    @RequestMapping(value = "/aggiorna01")
    public RegistrazioneDto01 aggiorna() {
        System.out.println("Siamo in aggiorna!");
        RegistrazioneDto01 rx = new RegistrazioneDto01();
        rx.setSessione("123stella!");
        return rx;
    }

}

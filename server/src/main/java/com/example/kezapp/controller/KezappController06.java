package com.example.kezapp.controller;

import com.example.kezapp.model.*;
import java.util.*;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class KezappController06 {

    List<Chat06> chats = new ArrayList<>();
    List<Messaggio06> msgs = new ArrayList<>();

    @RequestMapping(value = "/registrazione06")
    @ResponseBody
    public RegistrazioneDto06 registrazione(@RequestBody RichiediRegistrazioneDto06 dto) {
        System.out.println("Siamo in registrazione");

        boolean trovato = false;
        for (Chat06 chat : chats) {
            if (chat.getNickname().equalsIgnoreCase(dto.getNickname())) {
                trovato = true;
                break;
            }
        }

        RegistrazioneDto06 rx = new RegistrazioneDto06();
        if (!trovato) {

            Chat06 cx = new Chat06();
            cx.setNickname(dto.getNickname());
            // genera la sessione
            double d = Math.random();

            // non verifico se già esiste (FIXME)
            cx.setSessione(Double.toString(d));
            chats.add(cx);

            rx.setContatti(chats);
            rx.setSessione(cx.getSessione());
            rx.setMessaggi(msgs);
            System.out.println("Nickname non trovato");
        } else {
            // ritorno tutto vuoto in quanto non posso riutilizzare nickname
            rx.setContatti(Collections.emptyList());
            rx.setSessione(null);
            rx.setMessaggi(Collections.emptyList());
            System.out.println("Nickname trovato");
        }

        return rx;
    }

    @RequestMapping(value = "/invia-tutti06")
    @ResponseBody
    public RegistrazioneDto06 inviaTutti(@RequestBody InviaMessaggioDto06 dto) {
        System.out.println("Siamo in inviaTutti!");
        // cerco se esiste la sessione ...
        boolean trovato = false;
        Chat06 cx = null;
        for (Chat06 chat : chats) {
            if (chat.getSessione().equalsIgnoreCase(dto.getSessione())) {
                trovato = true;
                cx = chat;
                break;
            }
        }

        RegistrazioneDto06 rx = new RegistrazioneDto06();

        // ... se esiste aggiungo un messaggio e ritorno pieno
        if (trovato) {
            // creo nuovo messaggio
            Messaggio06 msg = new Messaggio06();
            msg.setTesto(dto.getMessaggio());
            msg.setAliasMittente(cx.getNickname());
            msg.setAliasDestinatario(null);

            // aggiungo un messaggio alla lista dei messaggi
            msgs.add(msg);
            
            // ritorno i contatti
            List<Chat06> listaContatti = chats.parallelStream()
                    .filter(c -> !(c.getSessione().equals(dto.getSessione())))
                    .collect(Collectors.toList());
            // ritorno i messaggi
            Chat06 cy = cx;
            List<Messaggio06> listaMessaggi = msgs.parallelStream()
                    .filter( m -> !(m.getAliasMittente().equals(cy.getNickname())))
                    .collect(Collectors.toList());
            rx.setContatti(listaContatti);
            rx.setMessaggi(listaMessaggi);
        } else {
            // ... se non esiste non aggiungo nulla e ritorno vuoto
            rx.setContatti(Collections.emptyList());
            rx.setMessaggi(Collections.emptyList());
        }
        return rx;
    }

    @RequestMapping(value = "/invia06")
    @ResponseBody
    public RegistrazioneDto06 inviaUno(@RequestBody InviaMessaggioDto06 dto) {
        System.out.println("Inviato a una persona");
        return new RegistrazioneDto06();
    }

    @RequestMapping(value = "/aggiorna06")
    public RegistrazioneDto06 aggiorna() {
        System.out.println("Aggiornamento");
        return new RegistrazioneDto06();
    }
}

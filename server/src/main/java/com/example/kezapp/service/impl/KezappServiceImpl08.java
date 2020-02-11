/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.kezapp.service.impl;

import com.example.kezapp.model.Chat08;
import com.example.kezapp.model.InviaMessaggioDto08;
import com.example.kezapp.model.Messaggio08;
import com.example.kezapp.model.RegistrazioneDto08;
import com.example.kezapp.model.RichiediMessaggiDto08;
import com.example.kezapp.model.RichiediRegistrazioneDto08;
import com.example.kezapp.service.KezappService08;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author utente
 */

@Service
public class KezappServiceImpl08 implements KezappService08 {

    private List<Chat08> chats = new ArrayList<>();
    private List<Messaggio08> msgs = new ArrayList<>();

    @Override
    public RegistrazioneDto08 registrazione(RichiediRegistrazioneDto08 dto) {
        // verifico se già esiste il nick-name
        boolean trovato = false;
        for (Chat08 chat : chats) {
            if (chat.getNickname().equalsIgnoreCase(dto.getNickname())) {
                trovato = true;
                break;
            }
        }

        // preparo la variabile per la risposta
        RegistrazioneDto08 rx = new RegistrazioneDto08();

        // se non esiste lo creo e lo aggiungo alla lista dei contatti
        if (!trovato) {
            Chat08 cx = new Chat08();
            cx.setNickname(dto.getNickname());
            // genero la sessione (non verifico se già esiste FIXME)
            double d = Math.random();
            cx.setSessione(Double.toString(d));
            chats.add(cx);

            // filtro i contatti
            List<Chat08> listaContatti = removeMeFromChats(dto.getNickname());
            rx.setContatti(listaContatti);

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

    @Override
    public RegistrazioneDto08 inviaTutti(InviaMessaggioDto08 dto) {
        dto.setDestinatario(null);
        return inviaUno(dto);
    }

    @Override
    public RegistrazioneDto08 aggiorna(RichiediMessaggiDto08 dto) {
        Chat08 cx = findChat(dto.getSessione());
        RegistrazioneDto08 risp = new RegistrazioneDto08();
        // se non ho trovato la sessione ...
        if (cx == null) {
            // ritorno campi vuoti
            risp.setContatti(Collections.emptyList());
            risp.setMessaggi(Collections.emptyList());
        } else {
            // ... se l'ho trovata recupero e filtro le liste messaggi e contatti
            List<Chat08> lx = removeMeFromChats(cx.getNickname());
            risp.setContatti(lx);
            risp.setMessaggi(removeMeFromMessages(cx.getNickname()));
            risp.getMessaggi().forEach(s -> System.out.println(s));
        }
        return risp;
    }

    @Override
    public RegistrazioneDto08 inviaUno(InviaMessaggioDto08 dto) {
        // cerco se esiste la sessione ...
        Chat08 cx = findChat(dto.getSessione());

        // ricerca della sessione con operatori aggregati
//        trovato = chats.stream()
//                .filter(x -> x.getSessione().equalsIgnoreCase(dto.getSessione()))
//                .count() > 0;
        RegistrazioneDto08 rx = new RegistrazioneDto08();
        System.out.println(cx);
        // ... se esiste aggiungo un messaggio e ritorno pieno
        if (cx != null) {
            // creo nuovo messaggio
            Messaggio08 msg = new Messaggio08();
            msg.setTesto(dto.getMessaggio());
            msg.setAliasMittente(cx.getNickname());
            msg.setAliasDestinatario(dto.getDestinatario());

            // aggiungo un messaggio alla lista dei messaggi
            msgs.add(msg);
            System.out.println(msgs.size());

            // ritorno i contatti
            List<Chat08> listaContatti = removeMeFromChats(cx.getNickname());
            rx.setContatti(listaContatti);

            // ritorno i messaggi
            rx.setMessaggi(removeMeFromMessages(cx.getNickname()));
        } else {
            // ... se non esiste non aggiungo nulla e ritorno vuoto
            rx.setContatti(Collections.emptyList());
            rx.setMessaggi(Collections.emptyList());
        }
        return rx;
    }

    private List<Chat08> removeMeFromChats(String nick) {
        return chats.parallelStream()
                .filter(c -> !(c.getNickname().equals(nick)))
                .collect(Collectors.toList());
    }

    /**
     * Rimuove i messaggi del mittente passato per nickname
     *
     * @param nick il nickname di cui rimuovere i messaggi inviati
     * @return una lista di messaggi ripulita dei messaggi del nickname
     */
    private List<Messaggio08> removeMeFromMessages(String nick) {
        return msgs.parallelStream()
                .filter(m -> !(m.getAliasMittente().equals(nick)))
                .filter(m -> m.getAliasDestinatario() == null
                        || m.getAliasDestinatario().equals(nick))
                .collect(Collectors.toList());
    }

    /**
     * Cerca se esiste la sessione passata come parametro
     *
     * @param sessione la stringa con l'identificativo di sessione da cercare
     * @return la chat con la sessione data, se trovata, altrimenti null
     */
    private Chat08 findChat(String sessione) {
        // ricerca della sessione in maniera tradizionale
        Chat08 cx = null;
        for (Chat08 chat : chats) {
            if (chat.getSessione().equalsIgnoreCase(sessione)) {
                cx = chat;
                break;
            }
        }
        return cx;
    }

}

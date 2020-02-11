package com.example.kezapp.service.impl;

import com.example.kezapp.model.Chat00;
import com.example.kezapp.model.InviaMessaggioDto00;
import com.example.kezapp.model.Messaggio00;
import com.example.kezapp.model.RegistrazioneDto00;
import com.example.kezapp.model.RichiediMessaggioDto00;
import com.example.kezapp.model.RichiediRegistrazioneDto;
import com.example.kezapp.service.KezappService00;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class KezappServiceImpl00 implements KezappService00 {

    private List<Chat00> chats = new ArrayList<>();
    private List<Messaggio00> msgs = new ArrayList<>();

    @Override
    public RegistrazioneDto00 registrazione(RichiediRegistrazioneDto dto) {
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

            // filtro i contatti
            List<Chat00> listaContatti = removeMeFromChats(dto.getNickname());
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
    public RegistrazioneDto00 inviaTutti(InviaMessaggioDto00 dto) {
        // cerco se esiste la sessione ...
        Chat00 cx = findChat(dto.getSessione());

        // ricerca della sessione con operatori aggregati
//        trovato = chats.stream()
//                .filter(x -> x.getSessione().equalsIgnoreCase(dto.getSessione()))
//                .count() > 0;
        RegistrazioneDto00 rx = new RegistrazioneDto00();
        System.out.println(cx);
        // ... se esiste aggiungo un messaggio e ritorno pieno
        if (cx != null) {
            // creo nuovo messaggio
            Messaggio00 msg = new Messaggio00();
            msg.setTesto(dto.getMessaggio());
            msg.setAliasMittente(cx.getNickname());
            msg.setAliasDestinatario(null);

            // aggiungo un messaggio alla lista dei messaggi
            msgs.add(msg);
            System.out.println(msgs.size());

            // ritorno i contatti
            List<Chat00> listaContatti = removeMeFromChats(cx.getNickname());
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

    @Override
    public RegistrazioneDto00 aggiorna(RichiediMessaggioDto00 dto) {
        Chat00 cx = findChat(dto.getSessione());
        RegistrazioneDto00 risp = new RegistrazioneDto00();
        // se non ho trovato la sessione ...
        if (cx == null) {
            // ritorno campi vuoti
            risp.setContatti(Collections.emptyList());
            risp.setMessaggi(Collections.emptyList());
        } else {
            // ... se l'ho trovata recupero e filtro le liste messaggi e contatti
            List<Chat00> lx = removeMeFromChats(cx.getNickname());
            risp.setContatti(lx);
            risp.setMessaggi(removeMeFromMessages(cx.getNickname()));
            risp.getMessaggi().forEach(s -> System.out.println(s));
        }
        return risp;
    }

    private List<Chat00> removeMeFromChats(String nick) {
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
    private List<Messaggio00> removeMeFromMessages(String nick) {
        return msgs.parallelStream()
                .filter(m -> !(m.getAliasMittente().equals(nick)))
                .collect(Collectors.toList());
    }

    /**
     * Cerca se esiste la sessione passata come parametro
     *
     * @param sessione la stringa con l'identificativo di sessione da cercare
     * @return la chat con la sessione data, se trovata, altrimenti null
     */
    private Chat00 findChat(String sessione) {
        // ricerca della sessione in maniera tradizionale
        Chat00 cx = null;
        for (Chat00 chat : chats) {
            if (chat.getSessione().equalsIgnoreCase(sessione)) {
                cx = chat;
                break;
            }
        }
        return cx;
    }

}

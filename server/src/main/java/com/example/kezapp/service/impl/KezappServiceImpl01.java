package com.example.kezapp.service.impl;

import com.example.kezapp.model.Chat01;
import com.example.kezapp.model.InviaMessaggioDto01;
import com.example.kezapp.model.Messaggio01;
import com.example.kezapp.model.RegistrazioneDto01;
import com.example.kezapp.model.RichiediMessaggiDto01;
import com.example.kezapp.model.RichiediRegistrazioneDto;
import com.example.kezapp.service.KezappService01;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;


@Service
public class KezappServiceImpl01 implements KezappService01 {

    private List<Chat01> chats = new ArrayList<>();
    private List<Messaggio01> msgs = new ArrayList<>();

    @Override
    public RegistrazioneDto01 registrazione(RichiediRegistrazioneDto dto) {
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

            List<Chat01> listaContatti = removeMeFromChats(cx.getNickname());

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

    @Override
    public RegistrazioneDto01 inviaTutti(InviaMessaggioDto01 dto) {
        dto.setDestinatario(null);
        return inviaUno(dto);
    }

    /**
     * Rimuove i contatti del mittente passato per i nickname
     *
     * @param nickname il nickname di cui rimuovere i contatti inviati
     * @return una lista di contatti ripulita dei contatti del nickname
     */
    private List<Chat01> removeMeFromChats(String nick) {
        return chats.parallelStream()
                .filter(c -> !(c.getNickname().equals(nick)))
                .collect(Collectors.toList());
    }

    /**
     * Rimuove i messaggi del mittente passato per i nickname
     *
     * @param nickname il nickname di cui rimuovere i messaggi inviati
     * @return una lista di messaggi ripulita dei messaggi del nickname
     */
    private List<Messaggio01> removeMeFromMessaggi(String nickname) {
        return msgs.parallelStream()
                .filter(m -> !(m.getAliasMittente().equals(nickname)))
                .filter(m -> m.getAliasDestinatario() == null || m.getAliasDestinatario().equals(nickname))
                .collect(Collectors.toList());
    }

    private Chat01 findChat(String sessione) {
        Chat01 cx = null;
        for (Chat01 chat : chats) {
            if (chat.getSessione().equalsIgnoreCase(sessione)) {
                cx = chat;
                break;
            }
        }
        return cx;
    }

    @Override
    public RegistrazioneDto01 aggiorna(RichiediMessaggiDto01 dto) {
        // cerco se esiste la sessione ...
        Chat01 cx = findChat(dto.getSessione());

        //trovato = chats.stream().filter(x -> x.getSessione().equalsIgnoreCase(dto.getSessione())).count() >0;
        RegistrazioneDto01 risp = new RegistrazioneDto01();

        // se non ho trovato la sessione
        if (cx == null) {
            // ritorno campi vuoti
            risp.setContatti(Collections.emptyList());
            risp.setMessaggio(Collections.emptyList());

        } else {
            // se l'ho trovata recupero e filtro le liste messaggi 

            // ritorno i contatti
            risp.setContatti(removeMeFromChats(cx.getNickname()));

            // ritorno i messaggi
            risp.setMessaggio(removeMeFromMessaggi(cx.getNickname()));
        }
        return risp;
    }

    @Override
    public RegistrazioneDto01 inviaUno(InviaMessaggioDto01 dto) {
        // cerco se esiste la sessione ...
        Chat01 cx = findChat(dto.getSessione());

        //trovato = chats.stream().filter(x -> x.getSessione().equalsIgnoreCase(dto.getSessione())).count() >0;
        RegistrazioneDto01 rx = new RegistrazioneDto01();

        // ... se esiste aggiungo un messaggio e ritorno pieno
        if (cx != null) {
            // creo nuovo messaggio
            Messaggio01 msg = new Messaggio01();
            msg.setTesto(dto.getMessaggio());
            msg.setAliasMittente(cx.getNickname());
            msg.setAliasDestinatario(dto.getDestinatario());

            // aggiungo un messaggio alla lista dei messaggi
            msgs.add(msg);

            // ritorno i contatti
            List<Chat01> listaContatti = removeMeFromChats(cx.getNickname());
            // ritorno i messaggi
            Chat01 cy = cx;
            List<Messaggio01> listaMessaggi = removeMeFromMessaggi(cx.getNickname());
            rx.setContatti(listaContatti);
            rx.setMessaggio(listaMessaggi);
        } else {
            // ... se non esiste non aggiungo nulla e ritorno vuoto
            rx.setContatti(Collections.emptyList());
            rx.setMessaggio(Collections.emptyList());
        }

        return rx;
    }
}

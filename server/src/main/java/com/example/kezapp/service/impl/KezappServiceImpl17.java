
package com.example.kezapp.service.impl;

import com.example.kezapp.model.Chat00;
import com.example.kezapp.model.Chat17;
import com.example.kezapp.model.InviaMessaggioDto17;
import com.example.kezapp.model.Messaggio17;
import com.example.kezapp.model.RegistrazioneDto17;
import com.example.kezapp.model.RichiediMessaggioDto17;
import com.example.kezapp.model.RichiediRegistrazioneDto17;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.kezapp.service.KezappService17;
import java.util.Collections;
import java.util.stream.Collectors;

@Service
public class KezappServiceImpl17 implements KezappService17 {
    
    private List<Chat17> chats = new ArrayList<>();
    private List<Messaggio17> msgs = new ArrayList<>();

    @Override
    public RegistrazioneDto17 registrazione(RichiediRegistrazioneDto17 dto) {
        // verifico se esiste il nickname
        boolean trovato = false;
        for(Chat17 chat: chats) {
            if (chat.getNickname().equalsIgnoreCase(dto.getNickname())) {
                trovato = true;
                break;
            }
        }
        
        // preparo la variaòbile per la risposta
        RegistrazioneDto17 rx = new RegistrazioneDto17();
        
        // se non esiste lo creo e lo aggiungo alla lista dei contatti
        if (!trovato) {
            Chat17 cx = new Chat17();
            cx.setNickname(dto.getNickname());
            // genera la sessione (non verifico se già esiste FIXME)
            double d = Math.random();
            cx.setSessione(Double.toString(d));
            chats.add(cx);
            
            // filtro i contatti
            List<Chat17> listaContatti = removeMeFromChats(dto.getNickname());
            rx.setContatti(listaContatti);
            
            rx.setSessione(cx.getSessione());
            rx.setMessaggi(msgs);
        } else {
            // se esiste non aggingo nulla e ritorno cambi vuoti
            // perchè non è ammesso il riuso del nickname
            rx.setContatti(new ArrayList<>());
            rx.setSessione(null);
            rx.setMessaggi(new ArrayList<>());
        }
        return rx;
    }
    
    @Override
    public RegistrazioneDto17 aggiorna(RichiediMessaggioDto17 dto) {
        Chat17 cx = findChat(dto.getSessione());
        RegistrazioneDto17 risp = new RegistrazioneDto17();
        // se non ho trovato la sessione ...
        if (cx == null) {
            // ritorno campi vuoti
            risp.setContatti(Collections.emptyList());
            risp.setMessaggi(Collections.emptyList());
        } else {
            // ... se l'ho trovata recupero e filtro le liste messaggi e contatti
            List<Chat17> lx = removeMeFromChats(cx.getNickname());
            risp.setContatti(lx);
            risp.setMessaggi(removeMeFromMessages(cx.getNickname()));
        }
        return risp;
    }
    
    
    @Override
    public RegistrazioneDto17 inviaTutti(InviaMessaggioDto17 dto) {
        dto.setDestinatario(null);
        return inviaUno(dto);
    }
    
    @Override
    public RegistrazioneDto17 inviaUno(InviaMessaggioDto17 dto) {
        // cerco se esiste la sessione
        Chat17 cx = findChat(dto.getSessione());
        
        RegistrazioneDto17 rx = new RegistrazioneDto17();
        
        // ... se esiste aggiungo un messaggio e ritorno pieno
        if (cx != null) {
            // creo nuovo messaggio
            Messaggio17 msg = new Messaggio17();
            msg.setTesto(dto.getMessaggio());
            msg.setAliasMittente(cx.getNickname());
            msg.setAliasDestinatario(dto.getDestinatario());
            
            // aggiungo un messaggio alla lista dei messaggi
            msgs.add(msg);
            
            // ritorno i contatti
            List<Chat17> listaContatti = removeMeFromChats(cx.getNickname());
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
    
    private List<Chat17> removeMeFromChats(String nick) {
        return chats.parallelStream()
                .filter(c -> !(c.getNickname().equals(nick)))
                .collect(Collectors.toList());
    }
    
    /**
     * Cerca se esiste la sessione passata come parametro
     * @param sessione la stringa con l'identificativo di sessione da cercare
     * @return la chat con la sessione data, se trovata, altrimenti null
     * @param sessione
     * @return 
     */
    private Chat17 findChat(String sessione) {
        // ricerca della sessione in maniera tradizionale
        Chat17 cx = null;
        for (Chat17 chat : chats) {
            if (chat.getSessione().equalsIgnoreCase(sessione)) {
                cx = chat;
                break;
            }
        }
        return cx;
    }
    
    /**
     * Rimuove i messaggi del mittente passato per nickname
     * @param nick il nickname di cui rimuove i messaggi inviati
     * @return una lista di messaggi ripulita dei messaggi del nickname
     */
    private List<Messaggio17> removeMeFromMessages(String nick) {
        return msgs.parallelStream()
                .filter(m -> ! (m.getAliasDestinatario().equals(nick)))
                //.filter(m -> nick.equals(m.getAliasDestinatario()) 
                //            || m.getAliasDestinatario() == null)
                .filter(m -> m.getAliasDestinatario() == null
                            || m.getAliasDestinatario().equals(nick))
                .collect(Collectors.toList());
    }

}

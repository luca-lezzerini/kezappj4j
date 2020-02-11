/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.kezapp.service.impl;

import com.example.kezapp.model.Chat11;
import com.example.kezapp.model.InviaMessaggioDto11;
import com.example.kezapp.model.Messaggio11;
import com.example.kezapp.model.RegistrazioneDto11;
import com.example.kezapp.model.RichiediMessaggiDto11;
import com.example.kezapp.model.RichiediRegistrazioneDto;
import com.example.kezapp.model.RichiediRegistrazioneDto11;
import com.example.kezapp.service.KezappService11;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;


@Service
public class KezappServiceImpl11 implements KezappService11 {

    private List<Chat11> chats = new ArrayList<>();
    private List<Messaggio11> msgs = new ArrayList<>();
    
    @Override
    public RegistrazioneDto11 registrazione(RichiediRegistrazioneDto dto) {
        boolean trovato = false;
        for (Chat11 chat : chats) {
            if (chat.getNickname().equalsIgnoreCase(dto.getNickname()));
            trovato = true;
            break;
    }
        //preparo la variabile per la rispsota
        RegistrazioneDto11 rx = new RegistrazioneDto11();
 
        // se non esiste lo creo e lo aggiungo alal lsita contatti
        if (!trovato){
            Chat11 cx = new Chat11();
            cx.setNickname(dto.getNickname());
            // genera la sessione (non verifico se già esiste FIXME)
            double d = Math.random();
            cx.setSessione(Double.toString(d));
            chats.add(cx);
            
            //filtro i contatti
            List<Chat11> listaContatti = chats.parallelStream()
                    .filter(c -> !(c.getSessione().equals(dto.getNickname())))
                    .collect(Collectors.toList());
            
            rx.setSessione(cx.getSessione());
            rx.setMessaggi(msgs);
        }else{
            // se esiste non aggungo nulla e ritorno campi vuoti 
            // perchè non è ammesso il riuso del nickname
            rx.setContatti(new ArrayList<>());
            rx.setSessione(null);
            rx.setMessaggi(new ArrayList<>());
        }
        return rx;
    }

    @Override
    public RegistrazioneDto11 inviaTutti(InviaMessaggioDto11 dto) {
        dto.setDestinatario(null);
        return null;//InviaUno(dto);
    }
    
    private List<Chat11> removeMeFromChats(String nick) {
        return chats.parallelStream()
                    .filter(c -> !(c.getNickname().equals(nick)))
                    .collect(Collectors.toList());
    }
    
    /**
    * rimuove i messaggi del mittente passato per nickname
    * @param nick il nickname di cui rimuovere i messaggi inviati
    * @return una lista di messaggi ripulita dei messaggi del nickname
    * */
    
    private List<Messaggio11> removeMeFromMessages(String nick){
        return msgs.parallelStream()
                 .filter(m -> !(m.getAliasMittente().equals(nick)))
                 .filter(m -> m.getAliasDestinatario() == null 
                         || m.getAliasDestinatario().equals(nick))
                 .collect(Collectors.toList());
    }
    
    private Chat11 findChat(String sessione){
        // ricerca della sessione in maniera tradizionale
        Chat11 cx = null;
        for (Chat11 chat : chats){
            if (chat.getSessione().equalsIgnoreCase(sessione)){
                cx = chat;
                break;
            }
        }
        return cx;
    }

    @Override
    public RegistrazioneDto11 aggiorna(RichiediMessaggiDto11 dto) {
        Chat11 cx = findChat(dto.getSession());
        RegistrazioneDto11 risp = new RegistrazioneDto11();
        // se non ho trovato la sessione..
        if (cx == null){
            // ritorno campi vuoti
            risp.setContatti(Collections.emptyList());
            risp.setMessaggi(Collections.emptyList());
        }else{
            // ...se l'ho trovata recupero e filtro le liste messaggi e contatti
            List<Chat11> lx = removeMeFromChats(cx.getNickname());
            risp.setContatti(lx);
            risp.setMessaggi(removeMeFromMessages(cx.getNickname()));
            //risp.setContatti(removeMeFromChats(cx.getNickname()));
        }
        return risp;
    }

    @Override
    public RegistrazioneDto11 inviaUno(InviaMessaggioDto11 dto) {
        Chat11 cx = findChat(dto.getSessione());
    
        //ricerca della sessione con operatori aggregati
        // trovato = chats.stream()
        //        .filter(x -> x.getSessione().equalsIgnoreCase(dto.getSessione()))
        //        .count() > 0;
        
        RegistrazioneDto11 rx = new RegistrazioneDto11();
        //... se esiste aggiungo un messaggio
        if (cx != null){
            //creo nuovo messaggio
            Messaggio11 msg = new Messaggio11();
            msg.setTesto(dto.getMessaggio());
            msg.setAliasMittente(cx.getNickname());
            msg.setAliasDestinatario(null);
            
            //aggiungo un messaggio alla lista dei messaggi
            msgs.add(msg);
            
            //ritorno i contatti
            List<Chat11> listaContatti = chats.parallelStream()
                    .filter(c -> !(c.getSessione().equals(dto.getSessione())))
                    .collect(Collectors.toList());
            //ritorno i messaggi
            rx.setMessaggi(removeMeFromMessages(cx.getNickname()));
        }else{
            //... se non esiste non aggiungo nulla e ritorno vuoto
            rx.setContatti(Collections.emptyList());
            rx.setMessaggi(Collections.emptyList());
        }
        return rx;
 
    }
    
}

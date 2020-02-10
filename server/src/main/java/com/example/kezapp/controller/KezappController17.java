/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.kezapp.controller;

import com.example.kezapp.model.Chat17;
import com.example.kezapp.model.InviaMessaggioDto17;
import com.example.kezapp.model.Messaggio17;
import com.example.kezapp.model.RegistrazioneDto17;
import com.example.kezapp.model.RichiediRegistrazioneDto17;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Alessandro G.
 */

@CrossOrigin("*")
@RestController
public class KezappController17 {
    
    List<Chat17> chats = new ArrayList<Chat17>();
    List<Messaggio17> msgs = new ArrayList<>();
    
    @RequestMapping(value = "/registrazione17")
    @ResponseBody
    public RegistrazioneDto17 registrazione(@RequestBody RichiediRegistrazioneDto17 dto){
        System.out.println("Siamo in registrazione!");
        
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
            rx.setContatti(chats);
            rx.setSessione(cx.getSessione());
            rx.setMessaggi(msgs);
        } else {
            // se esiste non aggingo nulla e ritorno cambi vuoti
            // perchè non 
            rx.setContatti(new ArrayList<>());
            rx.setSessione(null);
            rx.setMessaggi(new ArrayList<>());
        }
        
        rx.setSessione("123stella");
        return rx;
    }
    
    @RequestMapping(value = "/inviatutti17")
    public RegistrazioneDto17 inviaTutti(@RequestBody InviaMessaggioDto17 dto){
        System.out.println("Siamo in inviaATutti!");
        RegistrazioneDto17 rx = new RegistrazioneDto17();
        
        // cerco se esiste la sessione
        boolean trovato = false;
        Chat17 cx = null;
        for (Chat17 chat: chats) {
            if (chat.getSessione().equalsIgnoreCase(dto.getSessione())) {
                trovato = true;
                cx = chat;
                break;
            }
        }
        
        // ... se esiste aggiungo un messaggio
        if (trovato) {
            // creo nuovo messaggio
            Messaggio17 msg = new Messaggio17();
            msg.setTesto(dto.getMessaggio());
            msg.setAliasMittente(cx.getNickname());
            msg.setAliasDestinatario(null);
            
            // aggiungo un messaggio alla lista dei messaggi
            msgs.add(msg);
            
            // ritorno i contatti
            List<Chat17> listaContatti = chats.parallelStream()
                    .filter(c -> !c.getSessione().equals(dto.getSessione()))
                    .collect(Collectors.toList());
            // ritorno i messaggi
            Chat17 cy = cx;
            List<Messaggio17> listaMessaggi = msgs.parallelStream()
                    .filter(m -> !m.getAliasMittente().equals(cy.getNickname()))
                    .collect(Collectors.toList());
            
            rx.setContatti(listaContatti);
            rx.setMessaggi(listaMessaggi);
            
        } else {
            // ... se non esiste non aggiungo nulla e ritorno vuoto
            rx.setContatti(Collections.emptyList());
            rx.setMessaggi(Collections.emptyList());
        }

        rx.setSessione("456");
        return rx;
    }
    
    @RequestMapping(value = "/inviauno17")
    public RegistrazioneDto17 inviaUno(@RequestBody InviaMessaggioDto17 dto){
        System.out.println("Siamo in inviaAUno!");
        RegistrazioneDto17 rx = new RegistrazioneDto17();
        
        
        
        rx.setSessione("789");
        return rx;
    }
    
    @RequestMapping(value = "/aggiorna17")
    public RegistrazioneDto17 aggiorna(){
        System.out.println("Siamo in aggiorna!");
        RegistrazioneDto17 rx = new RegistrazioneDto17();
        rx.setSessione("000");
        return rx;
    }
}

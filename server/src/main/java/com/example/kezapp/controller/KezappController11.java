/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.kezapp.controller;

import com.example.kezapp.model.Chat11;
import com.example.kezapp.model.InviaMessaggioDto11;
import com.example.kezapp.model.Messaggio11;
import com.example.kezapp.model.RegistrazioneDto11;
import com.example.kezapp.model.RichiediRegistrazioneDto11;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class KezappController11 {
    
    List<Chat11> chats = new ArrayList<Chat11>();
    List<Messaggio11> msgs = new ArrayList<>();

    @RequestMapping(value = "/registrazione11")
    @ResponseBody
    public RegistrazioneDto11 registrazione(@RequestBody RichiediRegistrazioneDto11 dto) {
        System.out.println("Siamo in registrazione!");
        
        // verifico se già esiste il nickname
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
            
            rx.setContatti(chats);
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

    @RequestMapping(value = "/inviaUno11")
    @ResponseBody
    public RegistrazioneDto11 inviaUno(@RequestBody InviaMessaggioDto11 dto) {
        System.out.println("Siamo in inviaUno!");
        RegistrazioneDto11 rx = new RegistrazioneDto11();
        rx.setSessione("123stella!");
        return rx;
    }
    
    @RequestMapping(value = "/inviaTutti11")
    
    public RegistrazioneDto11 inviaTutti(@RequestBody InviaMessaggioDto11 dto){
        System.out.println("Invia a tutti!");
        // cerco se esiste la sessione ...
        boolean trovato = false;
        Chat11 cx = null;
        for (Chat11 chat : chats){
            if (chat.getSessione().equalsIgnoreCase(dto.getSessione())){
                trovato = true;
                cx = chat;
                break;
            }
        }
        RegistrazioneDto11 rx = new RegistrazioneDto11();
        //... se esiste aggiungo un messaggio
        if (trovato){
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
            Chat11 cy = cx;
            List<Messaggio11> listaMessaggi = msgs.parallelStream()
                    .filter(m -> !(m.getAliasMittente().equals(cy.getNickname())))
                    .collect(Collectors.toList());
            rx.setContatti(listaContatti);
            rx.setMessaggi(listaMessaggi);
        }else{
            //... se non esiste non aggiungo nulla e ritorno vuoto
            rx.setContatti(Collections.emptyList());
            rx.setMessaggi(Collections.emptyList());
        }
        return rx;
        
    }
    
    @RequestMapping(value= "/aggiorna11")
    public RegistrazioneDto11 aggiorna(){
        System.out.println("Aggiorna");
        RegistrazioneDto11 ag = new RegistrazioneDto11();
        ag.setSessione("123456 stella!");
        return ag;
    }
}

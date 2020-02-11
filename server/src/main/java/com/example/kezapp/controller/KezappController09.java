package com.example.kezapp.controller;

import com.example.kezapp.model.Chat09;
import com.example.kezapp.model.InviaMessaggioDto09;
import com.example.kezapp.model.Messaggio09;
import com.example.kezapp.model.RegistrazioneDto09;
import com.example.kezapp.model.RichiediRegistrazioneDto09;
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
public class KezappController09 {

    List<Chat09> chats = new ArrayList<Chat09>();
    List<Messaggio09> msgs = new ArrayList<>();

    @RequestMapping(value = "/registrazione09")
    @ResponseBody

    public RegistrazioneDto09 registrazione(@RequestBody RichiediRegistrazioneDto09 dto) {

        System.out.println("Siamo in registrazione!");
        boolean trovato = false;
        for (Chat09 chat : chats) {
            if (chat.getNickname().equalsIgnoreCase(dto.getNickname())) {
                trovato = true;
                break;
            }
        }
        //Preparo variabile per la risposta 
        RegistrazioneDto09 rx = new RegistrazioneDto09();

        //Se non esiste lo creo e lo aggiungo alla lista dei contatti 
        if (!trovato) {
            Chat09 cx = new Chat09();
            cx.setNickname(dto.getNickname());
            //Genera sessione con un numero a caso con la virgola (non verifico se già esiste FIX ME )!
            double d = Math.random();
            cx.setSessione(Double.toString(d));
            chats.add(cx);
            rx.setContatti(chats);
            rx.setSessione(cx.getSessione());
            rx.setMessaggi(msgs);
        } else {
            //Se è trovato ritorno una lista di contatti vuota e sessione nulla
            rx.setContatti(new ArrayList<>());
            rx.setSessione(null);
            rx.setMessaggi(new ArrayList<>());
        }

        return rx;

    }
    // Request Body perchè proviene da una richiesta http

    @RequestMapping(value = "/inviaTutti09")
    @ResponseBody
    public RegistrazioneDto09 inviaTutti(@RequestBody InviaMessaggioDto09 dto) {
        System.out.println("Siamo in inviaTutti!");

        RegistrazioneDto09 rx = new RegistrazioneDto09();
        Messaggio09 msg = new Messaggio09();
        boolean found = false;
        Chat09 cx = null;
        //Cerco se esiste la sessione....
        for (Chat09 chat : chats) {
            if (chat.getSessione().equals(dto.getSessione())) {
                msg.setAliasMittente(chat.getNickname());
                found = true;
                cx = chat;
                break;
            }
        }
        //Se esiste aggiungo messaggio
        if (found) {
            Messaggio09 mex = new Messaggio09();
            msg.setTesto(dto.getMessaggio());
            msg.setAliasMittente(cx.getNickname());
            msg.setAliasDestinatario(null);
            //Aggiungo un messaggio alla lista dei messaggi
            msgs.add(mex);
            //ritorno i contatti
           List <Chat09> listaContatti =  chats.parallelStream()
                    .filter(c -> !(c.getSessione().equals(dto.getSessione())))
                    .collect(Collectors.toList());
           Chat09 cy = cx;
           List <Messaggio09> listaMessaggi = msgs.parallelStream()
                   .filter( m -> !(m.getAliasMittente().equals(cy.getNickname())))
                   .collect(Collectors.toList());
                   rx.setContatti(listaContatti);
                   rx.setMessaggi(listaMessaggi);
                   
            } else {
            //Se non esiste non aggiungo nulla e ritorno vuoto
            rx.setContatti( Collections.emptyList());
            rx.setMessaggi( Collections.emptyList());
            
        }


        return rx;
    }

    @RequestMapping(value = "/inviaUno09")

    public RegistrazioneDto09 inviaUno(@RequestBody InviaMessaggioDto09 dto) {

     return new RegistrazioneDto09();
    }

    @RequestMapping(value = "/aggiorna09")
    public RegistrazioneDto09 aggiorna() {
        System.out.println("Siamo in aggiorna!");
        RegistrazioneDto09 rx = new RegistrazioneDto09();
        rx.setSessione("123stella!");
        return rx;
    }

}

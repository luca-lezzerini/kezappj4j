package com.example.kezapp.controller;

import com.example.kezapp.model.Chat10;
import com.example.kezapp.model.InviaMessaggioDto10;
import com.example.kezapp.model.Messaggio10;
import com.example.kezapp.model.RegistrazioneDto10;
import com.example.kezapp.model.RichiediRegistrazioneDto10;
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
public class KezappController10 {
    
    List<Chat10> chats = new ArrayList<Chat10>();
    List<Messaggio10> msgs = new ArrayList<>();
    
    @RequestMapping(value = "/registrazione10")
    @ResponseBody
    public RegistrazioneDto10 registrazione(@RequestBody RichiediRegistrazioneDto10 dto){
        System.out.println("Siamo in registrazione!");
        
        //verifico se gia esiste il nickname
        boolean trovato = false;
        for(Chat10 chat: chats){
            if(chat.getNickname().equalsIgnoreCase(dto.getNickname())){
                trovato = true;
                break;
            }
        }
        
        //preparo la variabile per la risposta
        RegistrazioneDto10 rx = new RegistrazioneDto10();
        
        //se non esiste lo creo
        if(!trovato){
            Chat10 cx = new Chat10();
            cx.setNickname(dto.getNickname());
            
            //genero la sessione (non verifico se gia esiste FIXME!)
            double d = Math.random();
            cx.setSessione(Double.toString(d));
            chats.add(cx);
            
            rx.setContatti(chats);
            rx.setSessione(cx.getSessione());
            rx.setMessaggi(msgs);
        }else{
            //se esiste non ritorno nulla e ritorno campi vuoti perche non è ammesso il riuso del nickname
            rx.setContatti(new ArrayList<>());
            rx.setSessione(null);
            rx.setMessaggi(new ArrayList<>());
        }
        
        //rx.setSessione("123stella!");
        return rx;
    }
    
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    @RequestMapping(value = "/inviatutti10")
    @ResponseBody
    public RegistrazioneDto10 inviaTutti(@RequestBody InviaMessaggioDto10 dto){
        System.out.println("Siamo in Invia Tutti!");
        //cerco se esiste la sessione...
        boolean trovato = false;
        Chat10 cx = null;
        for(Chat10 chat : chats){
            if (chat.getSessione().equalsIgnoreCase(dto.getSessione())){
                trovato = true;
                cx = chat;
                break;
            }
        }
        
        //preparo la variabile per la risposta
        RegistrazioneDto10 rx = new RegistrazioneDto10();
        
        //...se esiste aggiungo un messaggio e ritorno pieno...
        if(trovato){
            //creo un nuovo messaggio
            Messaggio10 msg = new Messaggio10();
            msg.setTesto(dto.getMessaggio());
            msg.setAliasMittente(cx.getNickname());
            msg.setAliasDestinatario(null);
            
            //aggiungo un messaggio alla lista dei messaggi
            msgs.add(msg);
            
            //ritorno i contatti
            List<Chat10> listaContatti = chats.parallelStream()
            .filter(c -> !(c.getSessione().equals(dto.getSessione())))
            .collect(Collectors.toList());
            
            //ritorno i messaggi
            Chat10 cy = cx;
            List<Messaggio10> listaMessaggi = msgs.parallelStream()
                .filter(m -> !(m.getAliasMittente().equals(cy.getNickname())))
                .collect(Collectors.toList());
            rx.setContatti(listaContatti);
            rx.setMessaggi(listaMessaggi);
        }else{
            //...se non esiste non aggiungo nulla e ritorno vuoto
            rx.setContatti(Collections.emptyList());
            rx.setMessaggi(Collections.emptyList());
        }
        
        //rx.setSessione("Sessione Invia Tutti!");
        return rx;
    }
    
    @RequestMapping(value = "/inviauno10")
    @ResponseBody
    public RegistrazioneDto10 inviaUno(@RequestBody InviaMessaggioDto10 dto){
        System.out.println("Siamo in Invia Uno!");
        RegistrazioneDto10 rx = new RegistrazioneDto10();
        rx.setSessione("Sessione Invia Uno!");
        return rx;
    }
   
    @RequestMapping(value = "/aggiorna10")
    public RegistrazioneDto10 aggiorna(){
        System.out.println("Siamo in aggiorna!");
        RegistrazioneDto10 rx = new RegistrazioneDto10();
        rx.setSessione("Sessione Aggiorna!");
        return rx;
    }

}
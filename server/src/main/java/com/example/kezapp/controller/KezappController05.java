/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.kezapp.controller;

import com.example.kezapp.model.Chat05;
import com.example.kezapp.model.InviaMessaggioDto05;
import com.example.kezapp.model.Messaggio05;
import com.example.kezapp.model.RegistrazioneDto05;
import com.example.kezapp.model.RichiediRegistrazioneDto05;
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
 * @author utente
 */
@CrossOrigin("*")
@RestController
public class KezappController05 {
    
    List<Chat05> chats = new ArrayList<Chat05>();
    List<Messaggio05> msgs = new ArrayList<Messaggio05>();
    
    @RequestMapping(value = "/registrazione05")
    @ResponseBody
    public RegistrazioneDto05 registrazione(@RequestBody RichiediRegistrazioneDto05 dto){
        System.out.println("Siamo in registrazione");
        
        boolean trovato = false;
        for(Chat05 chat: chats){
         if(chat.getNickname().equalsIgnoreCase(dto.getNickname())){
            trovato = true;
            break;
         }
        }
        
        RegistrazioneDto05 rx = new RegistrazioneDto05();
        
        if(!trovato){
            Chat05 cx = new Chat05();
            cx.setNickname(dto.getNickname());
            double d = Math.random();
            cx.setSessione(Double.toString(d));
            chats.add(cx);
            
            rx.setContatti(chats);
            rx.setSessione(cx.getSessione());
            rx.setMessaggi(msgs);
        }else{
        rx.setContatti(new ArrayList<>());
        rx.setSessione(null);
        rx.setMessaggi(null);
        }
       return rx;
    }   
       
    @RequestMapping(value = "/inviatutti05")
    public RegistrazioneDto05 inviaTutti(@RequestBody InviaMessaggioDto05 dto){
        System.out.println("Siamo in invia a tutti");
         boolean trovato = false;
         Chat05 cx = null;
         RegistrazioneDto05 rx = new RegistrazioneDto05();
         for(Chat05 chat: chats){
             if(chat.getSessione().equalsIgnoreCase(dto.getSessione())){
                 trovato = true;
                 cx = chat;
                 break;
             }
         }
        //.. se esiste aggiungo un messaggio
        if(trovato){
            Messaggio05 msg = new Messaggio05();
            msg.setTesto(dto.getMessaggio());
            msg.setAliasMittente(cx.getNickname());
            msg.setAliasDestinatario(null);
            
            msgs.add(msg);
            
            List<Chat05> listaContatti = chats.parallelStream()
                    .filter(c -> !(c.getSessione().equals(dto.getSessione())))
                    .collect(Collectors.toList());
            Chat05 cy = cx;                
            List<Messaggio05> listaMessaggi = msgs.parallelStream()
                    .filter(m -> ! (m.getAliasMittente().equals(cy.getNickname())))
                    .collect(Collectors.toList());
            rx.setContatti(listaContatti);
            rx.setMessaggi(listaMessaggi);
            
        }else{
        
            //.. se non esiste non aggiungo nulla e ritorno vuoto
            rx.setContatti(Collections.emptyList());
            rx.setMessaggi(Collections.emptyList());
           }
        return rx;
    }
    
    @RequestMapping(value = "/inviauno05")
    public RegistrazioneDto05 inviaUno(@RequestBody InviaMessaggioDto05 dto){
        System.out.println("Siamo in invia a uno");
         RegistrazioneDto05 rx = new RegistrazioneDto05();
        return rx;
        }
    
    @RequestMapping(value = "/aggiorna05")
    public RegistrazioneDto05 aggiorna(){
        System.out.println("Siamo in aggiorna");
        RegistrazioneDto05 rx = new RegistrazioneDto05();
        rx.setSessione("123stella");
        return rx;
    }
    
    
}

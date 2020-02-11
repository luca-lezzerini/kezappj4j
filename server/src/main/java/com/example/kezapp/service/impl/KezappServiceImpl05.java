/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.kezapp.service.impl;

import com.example.kezapp.model.Chat05;
import com.example.kezapp.model.InviaMessaggioDto05;
import com.example.kezapp.model.Messaggio05;
import com.example.kezapp.model.RegistrazioneDto05;
import com.example.kezapp.model.RichiediMessaggioDto05;
import com.example.kezapp.model.RichiediRegistrazioneDto05;
import com.example.kezapp.service.KezappService05;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author utente
 */
@Service
public class KezappServiceImpl05 implements KezappService05  {
    
   private List<Chat05> chats = new ArrayList<Chat05>();
   private List<Messaggio05> msgs = new ArrayList<Messaggio05>();
    
    
    @Override
    public RegistrazioneDto05 registrazione(RichiediRegistrazioneDto05 dto) {
    
    
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
            
             
            List<Chat05> listaContatti = removeMeFromChats(dto.getNickname());
            rx.setContatti(listaContatti);
            rx.setSessione(cx.getSessione());
            rx.setMessaggi(msgs);
        }else{
        rx.setContatti(new ArrayList<>());
        rx.setSessione(null);
        rx.setMessaggi(null);
        }
       return rx;
    }   

    @Override
    public RegistrazioneDto05 inviaTutti(InviaMessaggioDto05 dto) {
        dto.setDestinatario(null);
        return inviaUno(dto);
    }

    @Override
    public RegistrazioneDto05 aggiorna(RichiediMessaggioDto05 dto) {
        Chat05 cx = findChat(dto.getSessione());
        RegistrazioneDto05 risp = new RegistrazioneDto05();
        //se non ho torvato la sessione
        if(cx == null){
            //ritorno campi vuoti
            risp.setContatti(Collections.emptyList());
            risp.setMessaggi(Collections.emptyList());
        }else{
            //se l ho trovata recupero e filtro le liste 
            risp.setContatti(removeMeFromChats(cx.getNickname()));
            risp.setMessaggi(removeMeFromMessages(cx.getNickname()));
        }
        
        return risp;
    }

    @Override
    public RegistrazioneDto05 inviaUno(InviaMessaggioDto05 dto) {
        Chat05 cx = findChat(dto.getSessione());
         RegistrazioneDto05 rx = new RegistrazioneDto05();
         
         //Ricerca della sessione con operatori aggregati
           //trovato = chats.stream()
             //    .filter(x -> x.getSessione().equalsIgnoreCase(dto.getSessione()))
              //   .count() > 0;
         
         
        //.. se esiste aggiungo un messaggio
        if(cx != null){
            Messaggio05 msg = new Messaggio05();
            msg.setTesto(dto.getMessaggio());
            msg.setAliasMittente(cx.getNickname());
            msg.setAliasDestinatario(dto.getDestinatario());
            
            msgs.add(msg);
            
            List<Chat05> listaContatti = removeMeFromChats(cx.getNickname());
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
    
  
    
    
    
    
    private List<Chat05> removeMeFromChats(String nick){
         return chats.parallelStream()
                    .filter(c -> !(c.getNickname().equals(nick)))
                    .collect(Collectors.toList());
    }
    
    /**
     * Cerca la sessione passata come parametro
     * @param sessione la stringa con l'identificativo di sessione da cercare
     * @return la chat con la sessione data, se trovata, altrimenti null
     */
    
    private Chat05 findChat(String sessione){
        Chat05 cx = null;
        for(Chat05 chat: chats){
             if(chat.getSessione().equalsIgnoreCase(sessione)){
                 cx = chat;
                 break;
             }
         }
        return cx;
    }
    
    
    private List<Messaggio05> removeMeFromMessages(String nick){
        return msgs.parallelStream()
                .filter(m -> !(m.getAliasMittente().equals(nick)))
                .filter(m -> m.getAliasDestinatario() == null 
                        || m.getAliasDestinatario().equals(nick)  )
                .collect(Collectors.toList());
    }
    
    
    
 }
    


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.kezapp.controller;

import com.example.kezapp.model.Chat08;
import com.example.kezapp.model.InviaMessaggioDto08;
import com.example.kezapp.model.Messaggio08;
import com.example.kezapp.model.RegistrazioneDto08;
import com.example.kezapp.model.RichiediRegistrazioneDto;
import com.example.kezapp.model.RichiediRegistrazioneDto08;
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

/**
 *
 * @author utente
 */
@CrossOrigin("*") // prihvati pagine generirane da qualsiasi server
@RestController
public class KezappController08 {
    List<Chat08> chats = new ArrayList<Chat08>();
    List<Messaggio08> msgs = new ArrayList<Messaggio08>();
    
    @RequestMapping(value = "/registrazione08")
    @ResponseBody
    public RegistrazioneDto08 registrazione(@RequestBody RichiediRegistrazioneDto dto){
        System.out.println("Siamo in registrazione!");
        boolean trovato = false;
        for(Chat08 chat : chats){
         if (chat.getNickname().equalsIgnoreCase(dto.getNickname())){
            trovato = true;
            break;
         }
        }
        // preparo la var per la risposta
        RegistrazioneDto08 rx =new RegistrazioneDto08();
        
        if(!trovato){
            Chat08 cx = new Chat08();
            cx.setNickname( dto.getNickname());
            // genera la sessione // non verifico se gia essiste, fixme!
            double d = Math.random();
            cx.setSessione(Double.toString(d));
            chats.add(cx);
            
            rx.setContatti(chats);
            rx.setSessione(cx.getSessione());
            rx.setMessaggi(msgs);
        }else{
            rx.setContatti(new ArrayList<>());
            rx.setSessione(null);
            rx.setMessaggi(new ArrayList<>());
        }
        
        
        rx.setSessione("123stella!");
        return rx;
    }
    @ResponseBody
    @RequestMapping(value = "/inviaUno08")
     public RegistrazioneDto08 inviaUno(@RequestBody InviaMessaggioDto08 dto){
   
        System.out.println("Siamo in invia tutti!");
        // cerco se essiste l asessione...
        //..se essiste aggiungo in messaggio e ritorno pieno
        //.. se non esiste non aggiungo nulla e ritorno vuoto
        
        RegistrazioneDto08 rx =new RegistrazioneDto08();
        rx.setSessione("123tutti!");
        return rx;
     }
      @ResponseBody
    @RequestMapping(value = "/inviaTutti08")
     public RegistrazioneDto08 inviaTutti08(@RequestBody InviaMessaggioDto08 dto){
        System.out.println("Siamo in Invia uno!");
        // cerco se essiste l asessione...
        boolean trovato = false;
        Chat08 cx = null;
        // tradizionalan nacin, naci ce samo jednu, tj prvu
        for(Chat08 chat: chats){
            if (chat.getSessione().equalsIgnoreCase(dto.getSessione()) ){
                trovato = true;
                cx = chat; // spremi sesione del trovato
                break;
            }
        }
        // ricerca con operatori aggregati
        //trovato = chats.stream()
        //        .filter(x->x.getSessione().equalsIgnoreCase(dto.getSessione()))
        //        .count() >0;
        
         RegistrazioneDto08 rx =new RegistrazioneDto08();
        //..se essiste aggiungo in messaggio e ritorno pieno
        if(trovato){
            Messaggio08 msg = new Messaggio08();
            msg.setTesto(dto.getMessaggio());
            msg.setAliasMittente(cx.getNickname());
            msg.setAliasDestinatario(null);
            //aggiungo un msg alla lista dei msfg
                msgs.add(msg);
                //ritorno i contatti
                List<Chat08> listaContatti = chats.parallelStream()
                        .filter( c -> !(c.getNickname().equals(dto.getNickname()))) // flitrira mene, tj salji svima osim meni
                        .collect(Collectors.toList()); // transforma stream to list
                //ritorno i msgi
                //String nn = cx.getNickname();
                Chat08 cy = cx;
                List<Messaggio08> listaMessaggi = msgs.parallelStream()
                        //.filter(m -> !(m.getAliasMittente().equals(nn)))
                   .filter(m -> !(m.getAliasMittente().equals(cy.getNickname())))
                        .collect(Collectors.toList());
                rx.setContatti(listaContatti);
                rx.setMessaggi(listaMessaggi);
                
        }else{
        //.. se non esiste non aggiungo nulla e ritorno vuoto
        rx.setContatti(Collections.emptyList());
        rx.setMessaggi(Collections.emptyList());
        }
       
        //rx.setSessione("123Uno!");
        return rx;
     }
     
    @ResponseBody
    @RequestMapping(value = "/aggiorna08")
     public RegistrazioneDto08 aggiorna08(){
        System.out.println("Siamo in aggiorna!");
        RegistrazioneDto08 rx =new RegistrazioneDto08();
        rx.setSessione("123 aggiorna!");
        return rx;
     }
}

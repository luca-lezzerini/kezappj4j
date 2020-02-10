
package com.example.kezapp.controller;

import com.example.kezapp.model.Chat07;
import com.example.kezapp.model.InviaMessaggioDto07;
import com.example.kezapp.model.Messaggio07;
import com.example.kezapp.model.RegistrazioneDto07;
import com.example.kezapp.model.RichiediRegistrazioneDto07;
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
public class KezappController07{
    List<Chat07> chats= new ArrayList<Chat07>();
    List<Messaggio07> mgsg= new ArrayList<>();
    @RequestMapping(value = "/registrazione07")
    @ResponseBody
    public RegistrazioneDto07 registrazione(@RequestBody RichiediRegistrazioneDto07 dto){
        System.out.println("siamo in registrazione :)");
        boolean trovato=false;
        for(Chat07 chat:chats){
            if(chat.getNickname().equalsIgnoreCase(dto.getNickname())){
                trovato=true;
                break;
            }
        }
        //preparo la variabile per la risposta
        RegistrazioneDto07 rx= new RegistrazioneDto07();
        //se nono esiste lo creo
        if(!trovato){
            Chat07 cx= new Chat07();
            cx.setNickname(dto.getNickname());
            double d = Math.random();
            //genero la sessione
            cx.setSessione(Double.toString(d));
            chats.add(cx);
            rx.setContatti(chats);
            
        }else{
            //se esiste lo metto a null, non torno nulla
            rx.setContatti(new ArrayList<>());
            rx.setSessione(null);
            rx.setMessaggi(new ArrayList<>());
        }
        
        
        rx.setSessione("123stella");
        return rx;
    }
    //invia a tutti
    @RequestMapping(value = "/inviaTutti07")
    @ResponseBody
    public RegistrazioneDto07 inviaTutti(@RequestBody InviaMessaggioDto07 dto){
        RegistrazioneDto07 rx = new RegistrazioneDto07();
        //cerco se esiste la sessione
        boolean trovato = false;
        Chat07 cx = null;
        for(Chat07 chat :chats ){
            if(chat.getSessione().equalsIgnoreCase(dto.getSessione())){
                trovato = true;
                cx = chat;
                break;
            }
        }
        //se esiste aggiungo un messaggio
        if(trovato){
            //creo nuovo messaggio
            Messaggio07 msg = new Messaggio07();
            msg.setTesto(dto.getMessaggio());
            msg.setAliasMittente(cx.getNickname());
            msg.setAliasDestinatario(null);
            mgsg.add(msg);
            //ritorno i contatti tranne il mio
            List<Chat07> listaContatti = chats.parallelStream()
                    .filter(c -> !(c.getSessione().equals(dto.getSessione())))
                    .collect(Collectors.toList());
            //ritorno i messaggi tranne i miei
            String cy = cx.getNickname();
            List<Messaggio07> listaMessaggi = mgsg.parallelStream()
                    .filter(m -> !(m.getAliasMittente().equals(cy)))
                    .collect(Collectors.toList());
            rx.setContatti(listaContatti);
            rx.setMessaggi(listaMessaggi);
            
        }else{
            //se non esiste non aggiungo nulla e non torno nulla
            rx.setContatti( Collections.emptyList());
            rx.setMessaggi( Collections.emptyList());
        }
        rx.setSessione("invia a tutti");
        return rx;
    }
    //invia a uno
    @RequestMapping(value = "/inviaUno07")
    @ResponseBody
    public RegistrazioneDto07 inviaUno(@RequestBody InviaMessaggioDto07 dto){
        RegistrazioneDto07 rx = new RegistrazioneDto07();
        rx.setSessione("invia a uno");
        return rx;
    }
    //aggiorna
    @RequestMapping(value = "/aggiorna07")
    public RegistrazioneDto07 aggiorna(){
        RegistrazioneDto07 rx = new RegistrazioneDto07();
        rx.setSessione("aggiorna");
        return rx;
    }
}

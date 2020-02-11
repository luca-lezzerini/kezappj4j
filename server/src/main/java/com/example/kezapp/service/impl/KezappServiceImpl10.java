package com.example.kezapp.service.impl;

import com.example.kezapp.model.Chat10;
import com.example.kezapp.model.InviaMessaggioDto10;
import com.example.kezapp.model.Messaggio10;
import com.example.kezapp.model.RegistrazioneDto10;
import com.example.kezapp.model.RichiediMessaggiDto10;
import com.example.kezapp.model.RichiediRegistrazioneDto10;
import com.example.kezapp.service.KezappService10;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class KezappServiceImpl10 implements KezappService10{
    
    private final List<Chat10> chats = new ArrayList<>();
    private final List<Messaggio10> msgs = new ArrayList<>();
    
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////REGISTRAZIONE/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    @Override
    public RegistrazioneDto10 registrazione(@RequestBody RichiediRegistrazioneDto10 dto){
        
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

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////INVIA A TUTTI/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    @Override
    public RegistrazioneDto10 inviaTutti(@RequestBody InviaMessaggioDto10 dto){
        
      dto.setDestinatario(null);
      return inviaUno(dto);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////INVIA A UNO/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    @Override
    public RegistrazioneDto10 inviaUno(@RequestBody InviaMessaggioDto10 dto){
        
        //cerco se esiste la sessione
        
        Chat10 cx = findChat(dto.getSessione());
       
        //trovato=chats.stream().filter(x -> x.getSessione().equalsIgnoreCase(dto.getSessione())).count()>0;
        //se esiste aggiungo un messaggio
        RegistrazioneDto10 rx = new RegistrazioneDto10();
        if(cx != null){
            //creo nuovo messaggio
            Messaggio10 messaggio = new Messaggio10();
            messaggio.setTesto(dto.getMessaggio());
            messaggio.setAliasMittente(cx.getNickname());
            messaggio.setAliasDestinatario(dto.getDestinatario());
            msgs.add(messaggio);
            //ritorno i contatti tranne il mio
            List<Chat10> listaContatti = removeMeFromChat(cx.getNickname());
                    
            //ritorno i messaggi tranne i miei
            
            //ritorno mess e contatti
            rx.setContatti(listaContatti);
            
            rx.setMessaggi(removeMeFromMessage(cx.getNickname()));
            
        }else{
            //se non esiste non aggiungo nulla e non torno nulla
            rx.setContatti( Collections.emptyList());
            rx.setMessaggi( Collections.emptyList());
        }
        //rx.setSessione("invia a tutti");
        return rx;
       
    }
    
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
///////////////////////////////AGGIORNA//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    @Override
    public RegistrazioneDto10 aggiorna(@RequestBody RichiediMessaggiDto10 dto){
              
         Chat10 cx = findChat(dto.getSessione());
        RegistrazioneDto10 rx = new RegistrazioneDto10();
        //cerco la sessione
         
       
        // se non ho trovato la sessione torno campi vuoti
        if(cx == null){
            rx.setContatti(Collections.emptyList());
            rx.setMessaggi(Collections.emptyList());
            //altrimenti
        }else{
            //ritorno i contatti tranne il mio
            rx.setContatti(removeMeFromChat(cx.getNickname()));
                    
            //ritorno i messaggi tranne i miei
            rx.setMessaggi(removeMeFromMessage(cx.getNickname()));
        }
            
        
       // rx.setSessione("aggiorna");
        return rx;
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
///////////////////////////////RIMUOVE I MIEI MESSAGGI///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
    private List<Messaggio10> removeMeFromMessage(String nickname){
        /**
         * rimuvere i messaggi dal mittente passato
         * param nickname di cui rimuovere i messaggi inviati
         * return una lista di messaggi ripulita dai messaggi del nickname
         */
              return msgs.parallelStream()
                    .filter(m -> !(m.getAliasMittente().equals(nickname)))     //nickname mai null,destinatario puo essere, se la prima condizione viene soddisfatta esce, senno prosegue con l'end
                    .filter(m -> m.getAliasDestinatario()== null
                    || m.getAliasDestinatario().equals(nickname))  
                    .collect(Collectors.toList());

    }
    
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
///////////////////////////////RIMUVOVE IL MIO NICKNAME DALLE MIE CHAT///////////////////////////////////////////////////////////////////////////////////////////////////
        
    private List<Chat10> removeMeFromChat(String nickname){
        /**
         * rimuvere i messaggi dal mittente passato
         * param nickname di cui rimuovere i messaggi inviati
         * return una lista di messaggi ripulita dai messaggi del nickname
         */
        return chats.parallelStream()
                    .filter(c -> !(c.getNickname().equals(nickname)))
                    .collect(Collectors.toList());

    }
    
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
/////////////////////////////////TROVA SESSIONE//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
    private Chat10 findChat(String sessione){
        /**
         * cerca se esiste la sessione
         * parametro sessione la stringa con l'identificativo
         * return chat con sessione data,se trovata,se no null
         */
         
        Chat10 cx = null;
        for(Chat10 chat :chats ){
            if(chat.getSessione().equalsIgnoreCase(sessione)){
                cx = chat;
                break;
            }
        }
        return cx;
    }
}

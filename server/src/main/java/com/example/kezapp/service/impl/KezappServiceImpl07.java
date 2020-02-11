
package com.example.kezapp.service.impl;

import com.example.kezapp.model.Chat07;
import com.example.kezapp.model.InviaMessaggioDto07;
import com.example.kezapp.model.Messaggio07;
import com.example.kezapp.model.RegistrazioneDto07;
import com.example.kezapp.model.RichiediMessaggioDto07;
import com.example.kezapp.model.RichiediRegistrazioneDto07;
import com.example.kezapp.service.KezappService07;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class KezappServiceImpl07 implements KezappService07 {
    List<Chat07> chats= new ArrayList<Chat07>();
    List<Messaggio07> mgsg= new ArrayList<>();
    @Override
    public RegistrazioneDto07 registrazione( RichiediRegistrazioneDto07 dto) {
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
            cx.setSessione(Double.toString(d));
            //genero la sessione
            chats.add(cx);
            List<Chat07> listaContatti = removeMeFromChat(dto.getNickname());
            rx.setContatti(listaContatti);      
            rx.setSessione(cx.getSessione());
            rx.setMessaggi(mgsg);
            
        }else{
            //se esiste lo metto a null, non torno nulla
            rx.setContatti(new ArrayList<>());
            rx.setSessione(null);
            rx.setMessaggi(new ArrayList<>());
        }
        
        
        
        return rx;
    }

    @Override
    public RegistrazioneDto07 inviaTutti(InviaMessaggioDto07 dto) {
      dto.setDestinatario(null);
      return inviaUno(dto); 
    }
    private List<Chat07> removeMeFromChat(String nickname ){
       return chats.parallelStream()
                    .filter(c -> !(c.getNickname().equals(nickname)))
                    .collect(Collectors.toList());
    }

    @Override
    public RegistrazioneDto07 aggiorna(RichiediMessaggioDto07 dto) {
      
         Chat07 cx = findChat(dto.getSessione());
        RegistrazioneDto07 rx = new RegistrazioneDto07();
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
    private Chat07 findChat(String sessione){
        /**
         * cerca se esiste la sessione
         * parametro sessione la stringa con l'identificativo
         * return chat con sessione data,se trovata,se no null
         */
         
        
        Chat07 cx = null;
        for(Chat07 chat :chats ){
            if(chat.getSessione().equalsIgnoreCase(sessione)){
                cx = chat;
                break;
            }
        }
        return cx;
    }
    private List<Messaggio07> removeMeFromMessage(String nickname){
        /**
         * rimuvere i messaggi dal mittente passato
         * param nickname di cui rimuovere i messaggi inviati
         * return una lista di messaggi ripulita dai messaggi del nickname
         */
              return mgsg.parallelStream()
                    .filter(m -> !(m.getAliasMittente().equals(nickname)))     //nickname mai null,destinatario puo essere, se la prima condizione viene soddisfatta esce, senno prosegue con l'end
                    .filter(m -> m.getAliasDestinatario()== null
                    || m.getAliasDestinatario().equals(nickname))  
                    .collect(Collectors.toList());
            
    }

    @Override
    public RegistrazioneDto07 inviaUno(InviaMessaggioDto07 dto) {
        //cerco se esiste la sessione
        
        Chat07 cx = findChat(dto.getSessione());
       
        //trovato=chats.stream().filter(x -> x.getSessione().equalsIgnoreCase(dto.getSessione())).count()>0;
        //se esiste aggiungo un messaggio
        RegistrazioneDto07 rx = new RegistrazioneDto07();
        if(cx != null){
            //creo nuovo messaggio
            Messaggio07 msg = new Messaggio07();
            msg.setTesto(dto.getMessaggio());
            msg.setAliasMittente(cx.getNickname());
            msg.setAliasDestinatario(dto.getDestinatario());
            mgsg.add(msg);
            //ritorno i contatti tranne il mio
            List<Chat07> listaContatti = removeMeFromChat(cx.getNickname());
                    
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
    
}
   


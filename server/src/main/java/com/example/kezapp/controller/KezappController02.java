package com.example.kezapp.controller;

import com.example.kezapp.model.Chat02;
import com.example.kezapp.model.InviaMessaggioDto02;
import com.example.kezapp.model.Messaggio02;
import com.example.kezapp.model.RegistrazioneDto02;
import com.example.kezapp.model.RichiediRegistrazioneDto;
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
public class KezappController02 {

    List<Chat02> chats = new ArrayList<>();
    List<Messaggio02> msgs = new ArrayList<>();

    @RequestMapping(value = "/registrazione02")
    @ResponseBody
    public RegistrazioneDto02 registrazione(@RequestBody RichiediRegistrazioneDto dto) {
        System.out.println("Siamo in registrazione!");

        //verifico se già esiste il nickname
        boolean trovato = false;
        for (Chat02 chat : chats) {
            if (chat.getNickname().equalsIgnoreCase(dto.getNickname())) {
                trovato = true;
                break;
            }
        }

        //preparo la variabile per la risposta
        RegistrazioneDto02 rx = new RegistrazioneDto02();

        //se non esiste lo creo e lo aggiungo alla lista dei contatti
        if (!trovato) {
            Chat02 cx = new Chat02();
            cx.setNickname(dto.getNickname());
            //genera la sessione (non verifico se già esiste)
            double d = Math.random();
            cx.setSessione(Double.toString(d));
            chats.add(cx);

            rx.setContatti(chats);
            rx.setSessione(cx.getSessione());
            rx.setMessaggi(msgs);
        } else {
            //se esiste non aggiungo nulla e ritorno campi vuoti
            //perchè non è ammesso il riuso dei nickname
            rx.setContatti(Collections.emptyList());
            rx.setSessione(null);
            rx.setMessaggi(Collections.emptyList());
        }
        return rx;
    }

    @RequestMapping(value = "/inviaTutti02")
    @ResponseBody
    public RegistrazioneDto02 inviaTutti(@RequestBody InviaMessaggioDto02 dto) {
        System.out.println("Siamo in inviaTutti!");
        RegistrazioneDto02 rx = new RegistrazioneDto02();
        Messaggio02 msg = new Messaggio02();
        boolean trov = false;
        
        // risale al nome utente del mittente dal valore della sessione
        for (Chat02 chat : chats) {
            if (chat.getSessione().equals(dto.getSessione())) {
                msg.setAliasMittente(chat.getNickname());
                trov = true;
                break;
            }
        }
        
        //se esiste il mittente
        if (trov) {
            //se il messaggio è vuoto non viene salvato
            if (dto.getMessaggio() == null || dto.getMessaggio().equals("")) {
                rx.setContatti(chats);
                rx.setSessione(dto.getSessione());
                rx.setMessaggi(msgs);
            } else {
                //salva il messaggio
                msg.setTesto(dto.getMessaggio());
                msg.setAliasDestinatario(dto.getDestinatario());
                msgs.add(msg);
                List<Chat02> cx = chats.parallelStream()
                        .filter(c -> !(c.getSessione().equals(dto.getSessione())))
                .collect(Collectors.toList());
                rx.setContatti(cx);
                rx.setSessione(dto.getSessione());
                List<Messaggio02> listaMessaggi = msgs.parallelStream()
                        .filter(m -> !(m.getAliasMittente().equals(msg.getAliasMittente())))
                        .collect(Collectors.toList());
                rx.setMessaggi(listaMessaggi);
            }
        } else {
            //se il mittente non esiste
            rx.setContatti(Collections.emptyList());
            //rx.setSessione(null);
            rx.setMessaggi(Collections.emptyList());
        }
        return rx;
    }

    @RequestMapping(value = "/inviaUno02")
    public RegistrazioneDto02 inviaUno() {
        System.out.println("Siamo in inviaUno!");
        return new RegistrazioneDto02();
    }

    @RequestMapping(value = "/aggiorna02")
    public RegistrazioneDto02 aggiorna() {
        System.out.println("Siamo in aggiorna!");
        return new RegistrazioneDto02();
    }

}

package com.example.kezapp.service.impl;

import com.example.kezapp.model.Chat02;
import com.example.kezapp.model.InviaMessaggioDto02;
import com.example.kezapp.model.Messaggio02;
import com.example.kezapp.model.RegistrazioneDto02;
import com.example.kezapp.model.RichiediMessaggioDto02;
import com.example.kezapp.model.RichiediRegistrazioneDto;
import com.example.kezapp.service.KezappService02;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class KezappServiceImpl02 implements KezappService02 {

    private List<Chat02> chats = new ArrayList<>();
    private List<Messaggio02> msgs = new ArrayList<>();

    @Override
    public RegistrazioneDto02 registrazione(RichiediRegistrazioneDto dto) {
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

            List<Chat02> listaContatti = removeNickFromChats(dto.getNickname());
            rx.setContatti(listaContatti);
            rx.setSessione(cx.getSessione());
            rx.setMessaggi(removeNickFromMsgs(dto.getNickname()));
        } else {
            //se esiste non aggiungo nulla e ritorno campi vuoti
            //perchè non è ammesso il riuso dei nickname
            rx.setContatti(Collections.emptyList());
            rx.setSessione(null);
            rx.setMessaggi(Collections.emptyList());
        }
        return rx;
    }

    @Override
    public RegistrazioneDto02 inviaTutti(InviaMessaggioDto02 dto) {
        dto.setDestinatario(null);
        return inviaUno(dto);
    }

    @Override
    public RegistrazioneDto02 inviaUno(InviaMessaggioDto02 dto) {
        // risale al nome utente del mittente dal valore della sessione
        Chat02 cx = findChat(dto.getSessione());
        if (cx != null) {
            //se il messaggio è vuoto non viene salvato
            if (dto.getMessaggio() == null || dto.getMessaggio().equals("")) {
                return aggiornaTrovato(cx.getNickname(), dto.getSessione());
            } else {
                //salva il messaggio
                Messaggio02 msg = new Messaggio02();
                msg.setTesto(dto.getMessaggio());
                msg.setAliasMittente(cx.getNickname());
                msg.setAliasDestinatario(dto.getDestinatario());
                System.out.println("Destinatario: " + msg.getAliasDestinatario());
                msgs.add(msg);
                return aggiornaTrovato(cx.getNickname(), dto.getSessione());
            }
        } else {
            //se il mittente non esiste
            return aggiornaNonTrovato();
        }
    }

    @Override
    public RegistrazioneDto02 aggiorna(RichiediMessaggioDto02 dto) {

        // verifico se esiste la sessione
        Chat02 cx = findChat(dto.getSessione());
        //se la sessione esiste
        if (cx != null) {
            return aggiornaTrovato(cx.getNickname(), dto.getSessione());
        } else {
            //se la sessione non esiste
            return aggiornaNonTrovato();
        }
    }

    private RegistrazioneDto02 aggiornaTrovato(String aliasMittente, String sessione) {
        RegistrazioneDto02 rx = new RegistrazioneDto02();
        rx.setContatti(removeNickFromChats(aliasMittente));
        rx.setSessione(sessione);
        rx.setMessaggi(removeNickFromMsgs(aliasMittente));
        return rx;
    }

    private RegistrazioneDto02 aggiornaNonTrovato() {
        RegistrazioneDto02 rx = new RegistrazioneDto02();
        rx.setContatti(Collections.emptyList());
        rx.setMessaggi(Collections.emptyList());
        return rx;
    }

    private List<Chat02> removeNickFromChats(String nick) {
        return chats.parallelStream()
                .filter(c -> !(c.getNickname().equals(nick)))
                .collect(Collectors.toList());
    }

    private List<Messaggio02> removeNickFromMsgs(String nick) {
        return msgs.parallelStream()
                .filter(m -> !(m.getAliasMittente().equals(nick)))
                .filter(m -> m.getAliasDestinatario() == null
                || m.getAliasDestinatario().equals(nick))
                .collect(Collectors.toList());
    }

    /**
     * Cerca se esiste la sessione passata come parametro
     *
     * @param sessione la stringa con l'identificativo di sessione da cercare
     * @return la chat con la sessione data, se trovata, altrimenti null
     */
    private Chat02 findChat(String sessione) {
        Chat02 cx = null;
        for (Chat02 chat : chats) {
            if (chat.getSessione().equalsIgnoreCase(sessione)) {
                cx = chat;
                break;
            }
        }
        return cx;
    }
}

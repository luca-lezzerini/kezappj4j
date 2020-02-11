package com.example.kezapp.service.impl;

import com.example.kezapp.model.*;
import com.example.kezapp.service.KezappService06;
import java.util.*;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class KezappServiceImpl06 implements KezappService06 {

    private List<Chat06> chats = new ArrayList<>();
    private List<Messaggio06> msgs = new ArrayList<>();

    @Override
    public RegistrazioneDto06 registrazione(RichiediRegistrazioneDto06 dto) {

        boolean trovato = false;
        for (Chat06 chat : chats) {
            if (chat.getNickname().equalsIgnoreCase(dto.getNickname())) {
                trovato = true;
                break;
            }
        }

        RegistrazioneDto06 rx = new RegistrazioneDto06();
        if (!trovato) {

            Chat06 cx = new Chat06();
            cx.setNickname(dto.getNickname());
            // genera la sessione
            double d = Math.random();
            // non verifico se già esiste (FIXME)
            cx.setSessione(Double.toString(d));
            chats.add(cx);

            List<Chat06> listaContatti = removeMeFromChats(dto.getNickname());

            rx.setContatti(listaContatti);
            rx.setSessione(cx.getSessione());
            rx.setMessaggi(msgs);
            System.out.println("Nickname non trovato");
        } else {
            // ritorno tutto vuoto in quanto non posso riutilizzare nickname
            rx.setContatti(Collections.emptyList());
            rx.setSessione(null);
            rx.setMessaggi(Collections.emptyList());
            System.out.println("Nickname trovato");
        }

        return rx;
    }

    @Override
    public RegistrazioneDto06 inviaUno(InviaMessaggioDto06 dto) {

        // cerco se esiste la sessione ...
        Chat06 cx = findChat(dto.getSessione());

        RegistrazioneDto06 rx = new RegistrazioneDto06();

        // ... se esiste aggiungo un messaggio e ritorno pieno
        if (cx != null) {
            // creo nuovo messaggio
            Messaggio06 msg = newMsg(dto, cx.getNickname());

            // aggiungo un messaggio alla lista dei messaggi
            msgs.add(msg);
            updateMsgChats(cx.getNickname(), rx);
        } else {
            // ... se non esiste non aggiungo nulla e ritorno vuoto
            setEmptyRegistrazioneDto(rx);
        }
        return rx;
    }

    @Override
    public RegistrazioneDto06 inviaTutti(InviaMessaggioDto06 dto) {
        return inviaUno(dto);
    }

    @Override
    public RegistrazioneDto06 aggiorna(RichiediMessaggiDto06 dto) {

        Chat06 cx = findChat(dto.getSessione());
        RegistrazioneDto06 rx = new RegistrazioneDto06();

        if (cx != null) {
            updateMsgChats(cx.getNickname(), rx);
        } else {
            // ... se non esiste non aggiungo nulla e ritorno vuoto
            setEmptyRegistrazioneDto(rx);
        }

        return rx;
    }

    /**
     * Rimuove l'utente attivo dalle chat
     *
     * @param nickname Nickname dell'utente
     * @return Una lista di contatti senza l'utente
     */
    private List<Chat06> removeMeFromChats(String nickname) {
        return chats.parallelStream()
                .filter(c -> !(c.getNickname().equals(nickname)))
                .collect(Collectors.toList());
    }

    /**
     * Rimuove messaggi dell'utente il cui nickname viene passato
     *
     * @param nickname Nickname dell'utente i cui messaggi devono essere
     * nascosti
     * @return Una lista senza i messaggi dell'utente il cui nickname è stato
     * passato
     */
    private List<Messaggio06> removeMyMessages(String nickname) {
        return msgs.parallelStream()
                .filter(m -> !(m.getAliasMittente()).equals(nickname))
                .filter(m -> (m.getAliasDestinatario()) == null
                || m.getAliasDestinatario().equals(nickname))
                .collect(Collectors.toList());
    }

    /**
     * Aggiorna i messaggi e le chat all'interno di un RegistrazioneDto
     *
     * @param nickname Nickname dell'utente collegato
     * @param rx Il dto RegistrazioneDto in cui salvare le liste
     */
    private void updateMsgChats(String nickname, RegistrazioneDto06 rx) {
        rx.setMessaggi(removeMyMessages(nickname));
        rx.setContatti(removeMeFromChats(nickname));
    }

    /**
     * Inserisce liste vuote all'interno di un RegistrazioneDto
     *
     * @param rx Il dto RegistrazioneDto in cui salvare le liste
     */
    private void setEmptyRegistrazioneDto(RegistrazioneDto06 rx) {
        rx.setContatti(Collections.emptyList());
        rx.setMessaggi(Collections.emptyList());
    }

    /**
     * Cerca se esiste la sessione passata come parametro
     *
     * @param sessione la string
     * @return la chat con la sessione data
     */
    private Chat06 findChat(String sessione) {
        Chat06 cx = null;
        for (Chat06 chat : chats) {
            if (chat.getSessione().equalsIgnoreCase(sessione)) {
                cx = chat;
                break;
            }
        }
        return cx;
    }

    /**
     * Crea un nuovo messaggio
     *
     * @param dto Il dto InviaMessaggioDto da cui prendere il destinatario e il
     * messaggio
     * @param nickname Il nickname del mittente
     * @return Il nuovo messaggio
     */
    private Messaggio06 newMsg(InviaMessaggioDto06 dto, String nickname) {
        Messaggio06 msg = new Messaggio06();
        msg.setTesto(dto.getMessaggio());
        msg.setAliasMittente(nickname);
        msg.setAliasDestinatario(dto.getDestinatario());
        return msg;
    }

}

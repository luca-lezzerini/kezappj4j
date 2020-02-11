package com.example.kezapp.service.impl;

import com.example.kezapp.model.Chat04;
import com.example.kezapp.model.InviaMessaggioDto04;
import com.example.kezapp.model.Messaggio04;
import com.example.kezapp.model.RegistrazioneDto04;
import com.example.kezapp.model.RichiediMessaggiDto04;
import com.example.kezapp.model.RichiediRegistrazioneDto04;
import com.example.kezapp.service.KezappService04;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class KezappServiceImpl04 implements KezappService04 {

    private List<Chat04> chats = new ArrayList<>();
    private List<Messaggio04> msgs = new ArrayList<>();

    private List<Chat04> getChatsExceptPersonal(String nick) {
        return chats
                .parallelStream()
                .filter(c -> !c.getNickname().equals(nick))
                .collect(Collectors.toList());
    }

    private List<Messaggio04> getMsgsExceptPersonal(String nick) {
        return msgs
                .parallelStream()
                .filter(m -> !m.getAliasMittente().equals(nick))
                .filter(m -> m.getAliasDestinatario() == null || m.getAliasDestinatario().equals(nick))
                .collect(Collectors.toList());
    }

    @Override
    public RegistrazioneDto04 registrazione(RichiediRegistrazioneDto04 dto) {
        boolean trovato = false;
        for (Chat04 chat : chats) {
            if (chat.getNickname().equalsIgnoreCase(dto.getNickname())) {
                trovato = true;
                break;
            }
        }

        RegistrazioneDto04 rx = new RegistrazioneDto04();

        if (!trovato) {
            Chat04 cx = new Chat04();
            cx.setNickname(dto.getNickname());
            cx.setSessione(Double.toString(Math.random()));
            chats.add(cx);
            rx.setContatti(getChatsExceptPersonal(cx.getNickname()));
            rx.setMessaggi(getMsgsExceptPersonal(cx.getNickname()));
            rx.setSessione(cx.getSessione());
        } else {
            rx.setContatti(Collections.emptyList());
            rx.setMessaggi(Collections.emptyList());
        }

        return rx;
    }

    @Override
    public RegistrazioneDto04 inviaTutti(InviaMessaggioDto04 dto) {
        dto.setDestinatario(null);
        return inviaUno(dto);
    }

    @Override
    public RegistrazioneDto04 aggiorna(RichiediMessaggiDto04 dto) {
        RegistrazioneDto04 rx = new RegistrazioneDto04();
        Chat04 chatTrovata = cercaChat(dto.getSessione());
        if (chatTrovata != null) {
            rx.setContatti(getChatsExceptPersonal(chatTrovata.getNickname()));
            rx.setMessaggi(getMsgsExceptPersonal(chatTrovata.getNickname()));
        } else {
            rx.setContatti(Collections.emptyList());
            rx.setMessaggi(Collections.emptyList());
        }
        return rx;
    }

    private Chat04 cercaChat(String sessione) {
        Chat04 chatTrovata = null;
        for (Chat04 chat : chats) {
            if (chat.getSessione().equals(sessione)) {
                chatTrovata = chat;
                break;
            }
        }
        return chatTrovata;
    }

    @Override
    public RegistrazioneDto04 inviaUno(InviaMessaggioDto04 dto) {
        RegistrazioneDto04 rx = new RegistrazioneDto04();
        Chat04 chatTrovata = cercaChat(dto.getSessione());
        if (chatTrovata != null) {
            Messaggio04 msg = new Messaggio04();
            msg.setAliasDestinatario(dto.getDestinatario());
            msg.setAliasMittente(chatTrovata.getNickname());
            msg.setTesto(dto.getMessaggio());
            msgs.add(msg);
            rx.setContatti(getChatsExceptPersonal(chatTrovata.getNickname()));
            rx.setMessaggi(getMsgsExceptPersonal(chatTrovata.getNickname()));
        } else {
            rx.setContatti(Collections.emptyList());
            rx.setMessaggi(Collections.emptyList());
        }
        return rx;
    }
}

package com.example.kezapp.model;

import java.util.ArrayList;
import java.util.List;

public class RegistrazioneDto09 {
    private List<Chat09> contatti;
    private List<Messaggio09> messaggi;
    private String sessione;

    public RegistrazioneDto09() {
        contatti = new ArrayList<>();
        messaggi = new ArrayList<>();
    }

    public RegistrazioneDto09(List<Chat09> contatti, List<Messaggio09> messaggi, String sessione) {
        this.contatti = contatti;
        this.messaggi = messaggi;
        this.sessione = sessione;
    }

    public List<Chat09> getContatti() {
        return contatti;
    }

    public void setContatti(List<Chat09> contatti) {
        this.contatti = contatti;
    }

    public List<Messaggio09> getMessaggi() {
        return messaggi;
    }

    public void setMessaggi(List<Messaggio09> messaggi) {
        this.messaggi = messaggi;
    }

    public String getSessione() {
        return sessione;
    }

    public void setSessione(String sessione) {
        this.sessione = sessione;
    }
    
    
    
}

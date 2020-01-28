package com.example.kezapp.model;

import java.util.ArrayList;
import java.util.List;

public class RegistrazioneDto00 {
    private List<Chat00> contatti;
    private List<Messaggio00> messaggi;
    private String sessione;

    public RegistrazioneDto00() {
        contatti = new ArrayList<>();
        messaggi = new ArrayList<>();
    }

    public RegistrazioneDto00(List<Chat00> contatti, List<Messaggio00> messaggi, String sessione) {
        this.contatti = contatti;
        this.messaggi = messaggi;
        this.sessione = sessione;
    }

    public List<Chat00> getContatti() {
        return contatti;
    }

    public void setContatti(List<Chat00> contatti) {
        this.contatti = contatti;
    }

    public List<Messaggio00> getMessaggi() {
        return messaggi;
    }

    public void setMessaggi(List<Messaggio00> messaggi) {
        this.messaggi = messaggi;
    }

    public String getSessione() {
        return sessione;
    }

    public void setSessione(String sessione) {
        this.sessione = sessione;
    }
    
    
    
}

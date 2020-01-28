package com.example.kezapp.model;

import java.util.List;

public class RegistrazioneDto10 {
    
    private String sessione;
    private List<Chat10> contatti;
    private List<Messaggio10> messaggi;

    public RegistrazioneDto10() {
    }

    public RegistrazioneDto10(String sessione, List<Chat10> contatti, List<Messaggio10> messaggi) {
        this.sessione = sessione;
        this.contatti = contatti;
        this.messaggi = messaggi;
    }

    public String getSessione() {
        return sessione;
    }

    public void setSessione(String sessione) {
        this.sessione = sessione;
    }

    public List<Chat10> getContatti() {
        return contatti;
    }

    public void setContatti(List<Chat10> contatti) {
        this.contatti = contatti;
    }

    public List<Messaggio10> getMessaggi() {
        return messaggi;
    }

    public void setMessaggi(List<Messaggio10> messaggi) {
        this.messaggi = messaggi;
    }
    
    
    
}

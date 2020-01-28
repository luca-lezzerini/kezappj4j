
package com.example.kezapp.model;

import java.util.List;


public class RegistrazioneDto07 {
    private List<Chat07> contatti;
    private List<Messaggio07> messaggi;
    private String sessione;

    public List<Chat07> getContatti() {
        return contatti;
    }

    public void setContatti(List<Chat07> contatti) {
        this.contatti = contatti;
    }

    public List<Messaggio07> getMessaggi() {
        return messaggi;
    }

    public void setMessaggi(List<Messaggio07> messaggi) {
        this.messaggi = messaggi;
    }

    public String getSessione() {
        return sessione;
    }

    public void setSessione(String sessione) {
        this.sessione = sessione;
    }

    public RegistrazioneDto07(List<Chat07> contatti, List<Messaggio07> messaggi, String sessione) {
        this.contatti = contatti;
        this.messaggi = messaggi;
        this.sessione = sessione;
    }

    public RegistrazioneDto07() {
    }
    
}

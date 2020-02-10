package com.example.kezapp.model;

import java.util.ArrayList;
import java.util.List;

public class RegistrazioneDto06 {

    private List<Chat06> contatti;
    private List<Messaggio06> messaggi;
    private String sessione;

    public RegistrazioneDto06(List<Chat06> contatti, List<Messaggio06> messaggi, String sessione) {
        this.contatti = contatti;
        this.messaggi = messaggi;
        this.sessione = sessione;
    }

    public RegistrazioneDto06() {
        contatti = new ArrayList<>();
        messaggi = new ArrayList<>();
    }

    public List<Chat06> getContatti() {
        if (contatti == null) {
            contatti = new ArrayList<>();
        }
        return contatti;
    }

    public void setContatti(List<Chat06> contatti) {
        this.contatti = contatti;
    }

    public List<Messaggio06> getMessaggi() {
        if (messaggi == null) {
            messaggi = new ArrayList<>();
        }
        return messaggi;
    }

    public void setMessaggi(List<Messaggio06> messaggi) {
        this.messaggi = messaggi;
    }

    public String getSessione() {
        return sessione;
    }

    public void setSessione(String sessione) {
        this.sessione = sessione;
    }

}

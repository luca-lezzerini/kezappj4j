
package com.example.kezapp.model;

import java.util.ArrayList;


public class RegistrazioneDto13 {
    private ArrayList<Chat13> contatti;
    private ArrayList<Messaggio13> messaggi;
    private String sessione;

    public RegistrazioneDto13(ArrayList<Chat13> contatti, ArrayList<Messaggio13> messaggi, String sessione) {
        this.contatti = contatti;
        this.messaggi = messaggi;
        this.sessione = sessione;
    }

    public RegistrazioneDto13() {
        messaggi = new ArrayList<>();
        contatti = new ArrayList<>();
    }
    
    

    public ArrayList<Chat13> getContatti() {
        return contatti;
    }

    public void setContatti(ArrayList<Chat13> contatti) {
        this.contatti = contatti;
    }

    public ArrayList<Messaggio13> getMessaggi() {
        return messaggi;
    }

    public void setMessaggi(ArrayList<Messaggio13> messaggi) {
        this.messaggi = messaggi;
    }

    public String getSessione() {
        return sessione;
    }

    public void setSessione(String sessione) {
        this.sessione = sessione;
    }
    
    
}

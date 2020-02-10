/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.kezapp.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author utente
 */
public class RegistrazioneDto05 {
    private List<Chat05> contatti;
    private List<Messaggio05> messaggi;
    private String sessione;
    
    public RegistrazioneDto05() {
    }

    public RegistrazioneDto05(ArrayList<Chat05> contatti, ArrayList<Messaggio05> messaggi, String sessione) {
        this.contatti = contatti;
        this.messaggi = messaggi;
        this.sessione = sessione;
    }

    public List<Chat05> getContatti() {
        return contatti;
    }

    public void setContatti(List<Chat05> contatti) {
        this.contatti = contatti;
    }

    public List<Messaggio05> getMessaggi() {
        return messaggi;
    }

    public void setMessaggi(List<Messaggio05> messaggi) {
        this.messaggi = messaggi;
    }

    public String getSessione() {
        return sessione;
    }

    public void setSessione(String sessione) {
        this.sessione = sessione;
    }
    
}

    
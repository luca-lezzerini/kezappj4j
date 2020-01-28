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
public class RegistrazioneDto18 {
    private String sessione;
    private List<Chat18> contatti;
    private List<Messaggio18> messaggi;

    public RegistrazioneDto18() {
        contatti = new ArrayList<>();
        messaggi = new ArrayList<>();
    }

    public RegistrazioneDto18(String sessione, List<Chat18> contatti, List<Messaggio18> messaggi) {
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

    public List<Chat18> getContatti() {
        return contatti;
    }

    public void setContatti(List<Chat18> contatti) {
        this.contatti = contatti;
    }

    public List<Messaggio18> getMessaggi() {
        return messaggi;
    }

    public void setMessaggi(List<Messaggio18> messaggi) {
        this.messaggi = messaggi;
    }
    
}

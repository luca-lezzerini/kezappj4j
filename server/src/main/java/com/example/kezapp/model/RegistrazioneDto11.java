/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.kezapp.model;

import java.util.List;

/**
 *
 * @author utente
 */
public class RegistrazioneDto11 {
    private List<Chat11> contatti;
    private List<Messaggio11> messaggi;
    private String sessione;

    public List<Chat11> getContatti() {
        return contatti;
    }

    public void setContatti(List<Chat11> contatti) {
        this.contatti = contatti;
    }

    public List<Messaggio11> getMessaggi() {
        return messaggi;
    }

    public void setMessaggi(List<Messaggio11> messaggi) {
        this.messaggi = messaggi;
    }

    public String getSessione() {
        return sessione;
    }

    public void setSessione(String sessione) {
        this.sessione = sessione;
    }

    public RegistrazioneDto11(List<Chat11> contatti, List<Messaggio11> messaggi, String sessione) {
        this.contatti = contatti;
        this.messaggi = messaggi;
        this.sessione = sessione;
    }

    public RegistrazioneDto11() {
    }
    
    
}

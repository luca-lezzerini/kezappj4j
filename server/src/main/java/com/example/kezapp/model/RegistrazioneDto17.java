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
 * @author Alessandro G.
 */
public class RegistrazioneDto17 {
    private List<Chat17> contatti;
    private List<Messaggio17> messaggi;
    private String sessione;

    public RegistrazioneDto17() {
        contatti = new ArrayList<>();
        messaggi = new ArrayList<>();
    }

    public RegistrazioneDto17(List<Chat17> contatti, List<Messaggio17> messaggi, String sessione) {
        this.contatti = contatti;
        this.messaggi = messaggi;
        this.sessione = sessione;
    }


    public List<Chat17> getContatti() {
        return contatti;
    }

    public void setContatti(List<Chat17> contatti) {
        this.contatti = contatti;
    }

    public List<Messaggio17> getMessaggi() {
        return messaggi;
    }

    public void setMessaggi(List<Messaggio17> messaggi) {
        this.messaggi = messaggi;
    }

    public String getSessione() {
        return sessione;
    }

    public void setSessione(String sessione) {
        this.sessione = sessione;
    }
    
}

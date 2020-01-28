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
public class RegistrazioneDto12 {
    private List<Chat12> contatti;
    private List<Messaggio12> messaggi;
    private String sessione;

    public RegistrazioneDto12() {
    }

    public RegistrazioneDto12(List<Chat12> contatti, List<Messaggio12> messaggi, String sessione) {
        this.contatti = contatti;
        this.messaggi = messaggi;
        this.sessione = sessione;
    }

    public List<Chat12> getContatti() {
        if (contatti==null){
            contatti = new ArrayList<>();
        }
        return contatti;
    }

    public void setContatti(List<Chat12> contatti) {
        this.contatti = contatti;
    }

    public List<Messaggio12> getMessaggi() {
        if (messaggi==null){
            messaggi = new ArrayList<>();
        }
        return messaggi;
    }

    public void setMessaggi(List<Messaggio12> messaggi) {
        this.messaggi = messaggi;
    }

    public String getSessione() {
        return sessione;
    }

    public void setSessione(String sessione) {
        this.sessione = sessione;
    }
}

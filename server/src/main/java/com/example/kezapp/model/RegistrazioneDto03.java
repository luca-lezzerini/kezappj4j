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
public class RegistrazioneDto03 {
    private List<Chat03> contatti ;
    private List<Messaggio03> messaggi;
    private String sessione;

    public RegistrazioneDto03(List<Chat03> contatti, List<Messaggio03> messaggi, String sessione) {
        this.contatti = contatti;
        this.messaggi = messaggi;
        this.sessione = sessione;
    }

    public RegistrazioneDto03() {
    }

    public List<Chat03> getContatti() {
        return contatti;
    }

    public void setContatti(List<Chat03> contatti) {
        this.contatti = contatti;
    }

    public List<Messaggio03> getMessaggi() {
        return messaggi;
    }

    public void setMessaggi(List<Messaggio03> messaggi) {
        this.messaggi = messaggi;
    }

    public String getSessione() {
        return sessione;
    }

    public void setSessione(String sessione) {
        this.sessione = sessione;
    }
}

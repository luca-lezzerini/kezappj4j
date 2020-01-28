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
public class RegistrazioneDto {
    private List<Chat17> contatti;
    private List<Chat17> messaggi;
    private String sessione;

    public List<Chat17> getContatti() {
        return contatti;
    }

    public void setContatti(List<Chat17> contatti) {
        this.contatti = contatti;
    }

    public List<Chat17> getMessaggi() {
        return messaggi;
    }

    public void setMessaggi(List<Chat17> messaggi) {
        this.messaggi = messaggi;
    }

    public String getSessione() {
        return sessione;
    }

    public void setSessione(String sessione) {
        this.sessione = sessione;
    }
    
}

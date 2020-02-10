/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.kezapp.model;

import java.util.List;

/*
 *
 * @author utente
 */
public class RegistrazioneDto16 {
    private List<Chat16> contatti;
    private List<Messaggio16> messaggi;
    private String sessione;

    public RegistrazioneDto16(List<Chat16> contatti, List<Messaggio16> messaggi, String sessione) {
        this.contatti = contatti;
        this.messaggi = messaggi;
        this.sessione = sessione;
    }

    public RegistrazioneDto16() {
    }

    
    public List<Chat16> getContatti() {
        return contatti;
    }

    public void setContatti(List<Chat16> contatti) {
        this.contatti = contatti;
    }

    public List<Messaggio16> getMessaggi() {
        return messaggi;
    }

    public void setMessaggi(List<Messaggio16> messaggi) {
        this.messaggi = messaggi;
    }

    public String getSessione() {
        return sessione;
    }

    public void setSessione(String sessione) {
        this.sessione = sessione;
    }
    
    
}

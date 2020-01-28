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
public class RichiediMessaggioDto08 {
    private List<Chat08> contatti;
    private List<Messaggio08> messaggi; 
    private String sessione ;

    public RichiediMessaggioDto08() {
    }

    public RichiediMessaggioDto08(List<Chat08> contatti, List<Messaggio08> messaggi, String sessione) {
        this.contatti = contatti;
        this.messaggi = messaggi;
        this.sessione = sessione;
    }

    public List<Chat08> getContatti() {
        return contatti;
    }

    public void setContatti(List<Chat08> contatti) {
        this.contatti = contatti;
    }

    public List<Messaggio08> getMessaggi() {
        return messaggi;
    }

    public void setMessaggi(List<Messaggio08> messaggi) {
        this.messaggi = messaggi;
    }

    public String getSessione() {
        return sessione;
    }

    public void setSessione(String sessione) {
        this.sessione = sessione;
    }
    
}

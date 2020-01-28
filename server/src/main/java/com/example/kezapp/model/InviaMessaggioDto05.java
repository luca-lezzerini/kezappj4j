/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.kezapp.model;

/**
 *
 * @author utente
 */
public class InviaMessaggioDto05 {
    private String messaggio;
    private String sessione;
    private String Destinatario;

    public String getMessaggio() {
        return messaggio;
    }

    public void setMessaggio(String messaggio) {
        this.messaggio = messaggio;
    }

    public String getSessione() {
        return sessione;
    }

    public void setSessione(String sessione) {
        this.sessione = sessione;
    }

    public String getDestinatario() {
        return Destinatario;
    }

    public void setDestinatario(String Destinatario) {
        this.Destinatario = Destinatario;
    }

    public InviaMessaggioDto05(String messaggio, String sessione, String Destinatario) {
        this.messaggio = messaggio;
        this.sessione = sessione;
        this.Destinatario = Destinatario;
    }

    public InviaMessaggioDto05() {
    }
    
    
    
}

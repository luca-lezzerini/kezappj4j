/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.kezapp.model;

/**
 *
 * @author Alessandro G.
 */
public class InviaMessaggioDto17 {
    private String messaggio;
    private String sessione;
    private String destinatario;

    public InviaMessaggioDto17() {
    }

    public InviaMessaggioDto17(String messaggio, String sessione, String destinatario) {
        this.messaggio = messaggio;
        this.sessione = sessione;
        this.destinatario = destinatario;
    }

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
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }
    
}

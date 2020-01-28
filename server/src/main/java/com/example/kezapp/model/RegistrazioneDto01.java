package com.example.kezapp.model;

import java.util.ArrayList;
import java.util.List;

public class RegistrazioneDto01 {

    private List<Chat01> contatti;
    private List<Messaggio01> messaggio;
    private String sessione;

    public RegistrazioneDto01(List<Chat01> contatti, List<Messaggio01> messaggio, String sessione) {
        this.contatti = contatti;
        this.messaggio = messaggio;
        this.sessione = sessione;
    }

    public RegistrazioneDto01() {
    }
    
    public List<Chat01> getContatti() {
        if(contatti==null){
            contatti = new ArrayList<>();
        }
        return contatti;
    }

    public void setContatti(List<Chat01> contatti) {
        this.contatti = contatti;
    }

    public List<Messaggio01> getMessaggio() {
        if(messaggio==null){
            messaggio = new ArrayList<>();
        }
        return messaggio;
    }

    public void setMessaggio(List<Messaggio01> messaggio) {
        this.messaggio = messaggio;
    }

    public String getSessione() {
        return sessione;
    }

    public void setSessione(String sessione) {
        this.sessione = sessione;
    }

}

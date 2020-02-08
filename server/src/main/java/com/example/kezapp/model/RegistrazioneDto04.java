package com.example.kezapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RegistrazioneDto04 {

    private List<Chat04> contatti;
    private List<Messaggio04> messaggi;
    private String sessione;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.contatti);
        hash = 23 * hash + Objects.hashCode(this.messaggi);
        hash = 23 * hash + Objects.hashCode(this.sessione);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RegistrazioneDto04 other = (RegistrazioneDto04) obj;
        if (!Objects.equals(this.sessione, other.sessione)) {
            return false;
        }
        if (!Objects.equals(this.contatti, other.contatti)) {
            return false;
        }
        if (!Objects.equals(this.messaggi, other.messaggi)) {
            return false;
        }
        return true;
    }

    public RegistrazioneDto04() {
        contatti = new ArrayList<>();
        messaggi = new ArrayList<>();
    }

    public RegistrazioneDto04(List<Chat04> contatti, List<Messaggio04> messaggi, String sessione) {
        this.contatti = contatti;
        this.messaggi = messaggi;
        this.sessione = sessione;
    }

    public String getSessione() {
        return sessione;
    }

    public void setSessione(String sessione) {
        this.sessione = sessione;
    }

    public List<Chat04> getContatti() {
        return contatti;
    }

    public void setContatti(List<Chat04> contatti) {
        this.contatti = contatti;
    }

    public List<Messaggio04> getMessaggi() {
        return messaggi;
    }

    public void setMessaggi(List<Messaggio04> messaggi) {
        this.messaggi = messaggi;
    }
}

package com.example.kezapp.model;

import java.util.List;
import java.util.Objects;

public class RegistrazioneDto02 {

    private List<Chat02> contatti;
    private List<Messaggio02> messaggi;
    private String sessione;

    public RegistrazioneDto02() {
    }

    public RegistrazioneDto02(List<Chat02> contatti, List<Messaggio02> messaggi, String sessione) {
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

    public List<Chat02> getContatti() {
        return contatti;
    }

    public void setContatti(List<Chat02> contatti) {
        this.contatti = contatti;
    }

    public List<Messaggio02> getMessaggi() {
        return messaggi;
    }

    public void setMessaggi(List<Messaggio02> messaggi) {
        this.messaggi = messaggi;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.contatti);
        hash = 83 * hash + Objects.hashCode(this.messaggi);
        hash = 83 * hash + Objects.hashCode(this.sessione);
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
        final RegistrazioneDto02 other = (RegistrazioneDto02) obj;
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

}

package com.example.kezapp.model;

import java.util.Objects;

public class InviaMessaggioDto04 {
    private String messaggio;
    private String sessione;
    private String destinatario;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.messaggio);
        hash = 71 * hash + Objects.hashCode(this.sessione);
        hash = 71 * hash + Objects.hashCode(this.destinatario);
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
        final InviaMessaggioDto04 other = (InviaMessaggioDto04) obj;
        if (!Objects.equals(this.messaggio, other.messaggio)) {
            return false;
        }
        if (!Objects.equals(this.sessione, other.sessione)) {
            return false;
        }
        if (!Objects.equals(this.destinatario, other.destinatario)) {
            return false;
        }
        return true;
    }

    public InviaMessaggioDto04(String messaggio, String sessione, String destinatario) {
        this.messaggio = messaggio;
        this.sessione = sessione;
        this.destinatario = destinatario;
    }

    public InviaMessaggioDto04() {
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

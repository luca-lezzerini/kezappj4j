package com.example.kezapp.model;

import java.util.Objects;

public class RichiediMessaggioDto04 {

    private String sessione;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.sessione);
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
        final RichiediMessaggioDto04 other = (RichiediMessaggioDto04) obj;
        if (!Objects.equals(this.sessione, other.sessione)) {
            return false;
        }
        return true;
    }

    public RichiediMessaggioDto04() {
    }

    public RichiediMessaggioDto04(String sessione) {
        this.sessione = sessione;
    }

    public String getSessione() {
        return sessione;
    }

    public void setSessione(String sessione) {
        this.sessione = sessione;
    }
}

package com.example.kezapp.model;

import java.util.Objects;

public class Messaggio02 {

    private Long id;
    private String testo;
    private String aliasDestinatario;
    private String aliasMittente;

    public Messaggio02() {
    }

    public Messaggio02(Long id, String testo, String aliasDestinatario, String aliasMittente) {
        this.id = id;
        this.testo = testo;
        this.aliasDestinatario = aliasDestinatario;
        this.aliasMittente = aliasMittente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public String getAliasDestinatario() {
        return aliasDestinatario;
    }

    public void setAliasDestinatario(String aliasDestinatario) {
        this.aliasDestinatario = aliasDestinatario;
    }

    public String getAliasMittente() {
        return aliasMittente;
    }

    public void setAliasMittente(String aliasMittente) {
        this.aliasMittente = aliasMittente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.testo);
        hash = 47 * hash + Objects.hashCode(this.aliasDestinatario);
        hash = 47 * hash + Objects.hashCode(this.aliasMittente);
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
        final Messaggio02 other = (Messaggio02) obj;
        if (!Objects.equals(this.testo, other.testo)) {
            return false;
        }
        if (!Objects.equals(this.aliasDestinatario, other.aliasDestinatario)) {
            return false;
        }
        if (!Objects.equals(this.aliasMittente, other.aliasMittente)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}

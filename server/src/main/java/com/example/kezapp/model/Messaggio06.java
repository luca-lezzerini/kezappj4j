package com.example.kezapp.model;

public class Messaggio06 {

    private Long id;
    private String testo;
    private String aliasDestinatario;
    private String aliasMittente;

    public Messaggio06(Long id, String testo, String aliasDestinatario, String aliasMittente) {
        this.id = id;
        this.testo = testo;
        this.aliasDestinatario = aliasDestinatario;
        this.aliasMittente = aliasMittente;
    }

    public Messaggio06() {
    }

    public Long getId() {
        if (id == null) {
            id = 0L;
        }
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

}

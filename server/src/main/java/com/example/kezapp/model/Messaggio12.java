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
public class Messaggio12 {
    private Long id;
    private String testo;
    private String aliasDestinatario;
    private String aliasMittente;

    public Messaggio12(Long id, String testo, String aliasDestinatario, String aliasMittente) {
        this.id = id;
        this.testo = testo;
        this.aliasDestinatario = aliasDestinatario;
        this.aliasMittente = aliasMittente;
    }

    public Messaggio12() {
    }

    public Long getId() {
        if(id==null){
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

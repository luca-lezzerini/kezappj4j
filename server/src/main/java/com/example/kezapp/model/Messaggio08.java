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
public class Messaggio08 {
    private Long id;
    private String testo;
    private String aliasDestinario;
    private String aliasMittente;

    public Messaggio08(Long id, String testo, String aliasDestinario, String aliasMittente) {
        this.id = id;
        this.testo = testo;
        this.aliasDestinario = aliasDestinario;
        this.aliasMittente = aliasMittente;
    }

    public Messaggio08() {
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

    public String getAliasDestinario() {
        return aliasDestinario;
    }

    public void setAliasDestinario(String aliasDestinario) {
        this.aliasDestinario = aliasDestinario;
    }

    public String getAliasMittente() {
        return aliasMittente;
    }

    public void setAliasMittente(String aliasMittente) {
        this.aliasMittente = aliasMittente;
    }

}
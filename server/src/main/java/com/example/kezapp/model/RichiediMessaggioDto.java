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
public class RichiediMessaggioDTO {
    private String sessione;

    public RichiediMessaggioDTO(String sessione) {
        this.sessione = sessione;
    }

    public RichiediMessaggioDTO() {
    }

    
    public String getSessione() {
        return sessione;
    }

    public void setSessione(String sessione) {
        this.sessione = sessione;
    }
    
}

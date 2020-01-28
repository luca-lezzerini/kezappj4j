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
public class RichiediRegistrazioneDto12 {
    private String nickname;

    public RichiediRegistrazioneDto12(String nickname) {
        this.nickname = nickname;
    }

    public RichiediRegistrazioneDto12() {
    }
    
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    
}

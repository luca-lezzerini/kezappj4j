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
public class Chat05 {
    private Long id;
    private String sessione;
    private String nickname;

    public Long getId() {
        if (id == null){
            id = 0L;
        }
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSessione() {
        return sessione;
    }

    public void setSessione(String sessione) {
        this.sessione = sessione;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Chat05(Long id, String sessione, String nickname) {
        this.id = id;
        this.sessione = sessione;
        this.nickname = nickname;
    }

    public Chat05() {
    }
    
    
}

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
public class Chat03 {
    private Long id;

    public Long getId() {
        if (id == null){
            id = 0L;
        }
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSessione() {
        return sessione;
    }

    public void setSessione(String sessione) {
        this.sessione = sessione;
    }
    private String nickname;
    private String sessione;
    
    
    
    
    
    
    
    
    
    
    
    
    
}

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
public class Chat08 {
    private Long id;
    private String nickname;
    private String session;

    public Chat08() {
    }

    public Chat08(long id, String nickname, String session) {
        this.id = id;
        this.nickname = nickname;
        this.session = session;
    }
    
    public Long getId() {
        if(id== null){
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

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }
    
}

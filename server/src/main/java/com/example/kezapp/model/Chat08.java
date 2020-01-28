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
    private long id;
    private String nickName;
    private String session;

    public Chat08() {
    }

    public long getId() {
        return id;
    }

    public Chat08(long id, String nickName, String session) {
        this.id = id;
        this.nickName = nickName;
        this.session = session;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }
    
}

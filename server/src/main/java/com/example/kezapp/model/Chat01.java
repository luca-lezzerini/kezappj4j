package com.example.kezapp.model;

public class Chat01 {

    private Long id;
    private String nickname;
    private String sessione;

    public long getId() {
        if (id == null) {
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

}

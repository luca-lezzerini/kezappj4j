
package com.example.kezapp.model;


public class Chat07 {
    private Long id;
    private String nickname;
    private String sessione;

    public Long getId() {
        if(id==null){
            id=0L;
        }
        return id;
    }

    public void setId(Long id) {
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

    public Chat07(Long id, String nickname, String sessione) {
        this.id = id;
        this.nickname = nickname;
        this.sessione = sessione;
    }

    public Chat07() {
    }
    
    
}

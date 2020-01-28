package com.example.kezapp.model;

import java.util.Objects;

public class Chat04 {

    private Long id;
    private String nickname;
    private String sessione;

    public Chat04() {
    }

    public Chat04(Long id, String nickname, String sessione) {
        this.id = id;
        this.nickname = nickname;
        this.sessione = sessione;
    }

    public Long getId() {
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.nickname);
        hash = 97 * hash + Objects.hashCode(this.sessione);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Chat04 other = (Chat04) obj;
        if (!Objects.equals(this.nickname, other.nickname)) {
            return false;
        }
        if (!Objects.equals(this.sessione, other.sessione)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}

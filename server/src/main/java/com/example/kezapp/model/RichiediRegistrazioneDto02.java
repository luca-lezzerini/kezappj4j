package com.example.kezapp.model;

import java.util.Objects;

public class RichiediRegistrazioneDto02 {

    private String nickname;

    public RichiediRegistrazioneDto02() {
    }

    public RichiediRegistrazioneDto02(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.nickname);
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
        final RichiediRegistrazioneDto02 other = (RichiediRegistrazioneDto02) obj;
        if (!Objects.equals(this.nickname, other.nickname)) {
            return false;
        }
        return true;
    }

}

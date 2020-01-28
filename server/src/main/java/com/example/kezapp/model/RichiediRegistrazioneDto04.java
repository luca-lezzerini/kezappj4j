package com.example.kezapp.model;

import java.util.Objects;

public class RichiediRegistrazioneDto04 {

    private String nickname;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.nickname);
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
        final RichiediRegistrazioneDto04 other = (RichiediRegistrazioneDto04) obj;
        if (!Objects.equals(this.nickname, other.nickname)) {
            return false;
        }
        return true;
    }

    public RichiediRegistrazioneDto04() {
    }

    public RichiediRegistrazioneDto04(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}

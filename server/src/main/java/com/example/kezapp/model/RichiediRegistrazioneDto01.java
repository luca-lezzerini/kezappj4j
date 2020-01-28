package com.example.kezapp.model;

public class RichiediRegistrazioneDto01 {
    private String nickname;

    public RichiediRegistrazioneDto01(String nickname) {
        this.nickname = nickname;
    }

    public RichiediRegistrazioneDto01() {
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

}

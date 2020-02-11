/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.kezapp.service;

import com.example.kezapp.model.RegistrazioneDto08;
import com.example.kezapp.model.RichiediRegistrazioneDto;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author utente
 */
public interface KezappService08 {
    RegistrazioneDto08 registrazione(RichiediRegistrazioneDto dto);
}

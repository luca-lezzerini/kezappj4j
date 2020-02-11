import { RichiediMessaggiDto } from './richiedi-messaggi-dto';
import { Chat } from './chat';
import { Messaggio } from './messaggio';
import { RegistrazioneDto } from './registrazione-dto';
import { InviaMessaggioDto } from './invia-messaggio-dto';
import { RichiediRegistrazioneDto } from './richiedi-registrazione-dto';
import { Component } from '@angular/core';
import { Observable, observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {

  nickName = '';
  messaggio = '';
  sessione = '';
  messaggi: Messaggio[] = [];
  contatti: Chat[] = [];


  constructor(private http: HttpClient) { }

  registrazione() {
    // creazione dto con file da inviare
    const reg: RichiediRegistrazioneDto = new RichiediRegistrazioneDto();
    reg.nickname = this.nickName;

    // preparo la richiesta HTTP
    const obs: Observable<RegistrazioneDto> = this.http.post<RegistrazioneDto>('http://localhost:8080/registrazione04', reg);

    // creo la callback
    obs.subscribe(risposta => {
      this.messaggi = risposta.messaggi;
      this.contatti = risposta.contatti;
      this.sessione = risposta.sessione;
    });
  }

  inviaATutti() {
    if (this.messaggio !== '') {
      const sendAll: InviaMessaggioDto = new InviaMessaggioDto();
      sendAll.destinatario = null;
      sendAll.messaggio = this.messaggio;
      sendAll.sessione = this.sessione;
      const obs: Observable<RegistrazioneDto> = this.http.post<RegistrazioneDto>('http://localhost:8080/inviaTutti04', sendAll);
      obs.subscribe(risposta => {
        this.messaggi = risposta.messaggi;
        this.contatti = risposta.contatti;
      });
      this.messaggio = '';
    }
  }

  inviaUno(i: number) {
    if (this.messaggio !== '') {
      const im: InviaMessaggioDto = new InviaMessaggioDto();
      im.sessione = this.sessione;
      im.messaggio = this.messaggio;
      im.destinatario = this.contatti[i].nickname;
      this.http.post<RegistrazioneDto>('http://localhost:8080/inviaUno04', im).subscribe(
        risposta => {
          this.contatti = risposta.contatti;
          this.messaggi = risposta.messaggi;
        });
    }
  }

  aggiorna() {
    const aggiorna: RichiediMessaggiDto = new RichiediMessaggiDto();
    aggiorna.sessione = this.sessione;
    const obs: Observable<RegistrazioneDto> = this.http.post<RegistrazioneDto>('http://localhost:8080/aggiorna04', aggiorna);
    obs.subscribe(risposta => {
      this.contatti = risposta.contatti;
      this.messaggi = risposta.messaggi;
    });
  }

  disconnetti() {
    this.sessione = '';
    this.nickName = '';
    this.contatti = [];
    this.messaggi = [];
  }

}

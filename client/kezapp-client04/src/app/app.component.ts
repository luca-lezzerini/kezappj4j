import { Chat } from './chat';
import { Messaggio } from './messaggio';
import { RegistrazioneDto } from './registrazione-dto';
import { InviaMessaggioDto } from './invia-messaggio-dto';
import { RichiediRegistrazioneDto } from './richiedi-registrazione-dto';
import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {

  nickName: string;
  messaggio: string;
  sessione: string;
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
    const send: InviaMessaggioDto = new InviaMessaggioDto();
    send.destinatario = null;
    send.messaggio = this.messaggio;
    send.sessione = this.sessione;
    const obs: Observable<InviaMessaggioDto> = this.http.post<InviaMessaggioDto>('http://localhost:8080/inviaTutti04', send);
  }

  invia(i: number) {

  }

  aggiorna() {

  }

}

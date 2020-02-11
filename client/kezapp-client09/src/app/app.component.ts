import { InviaMessaggioDto } from './invia-messaggio-dto';
import { Messaggio } from './messaggio';
import { RegistrazioneDto } from './registrazione-dto';
import { RichiediRegistrazioneDto } from './richiedi-registrazione-dto';
import { RichiediMessaggioDto } from './richiedi-messaggio';
import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Chat } from './chat';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'Kezappclient09';
  nickName: string;
  messaggio: string;
  righe: string[];
  sessione: string;
  messaggi: Messaggio[] = [];
  contatti: Chat[] = [];

  constructor(private http: HttpClient) { }
  registrazione() {
    // Creo il dto con i dati da inviare
    const dx: RichiediRegistrazioneDto = new RichiediRegistrazioneDto();
    dx.nickname = this.nickName;

    // preparo la richiesta HTTP
    const oss: Observable<RegistrazioneDto> =
      this.http
        .post<RegistrazioneDto>('http://localhost:8080/registrazione09', dx);
    // Creo la callback
    oss.subscribe(risposta => {
      this.messaggi = risposta.messaggi;
      this.contatti = risposta.contatti;
      this.sessione = risposta.sessione;
    });
  }
  inviaTutti() {
    const invia: InviaMessaggioDto = new InviaMessaggioDto();
    invia.destinatario = null;
    invia.messaggio = this.messaggio;
    invia.sessione = this.sessione;
    const obs: Observable<RegistrazioneDto> = this.http.post<RegistrazioneDto>
      ('http://localhost:8080/InviaTutti09', invia);
    // Creo la callback
    obs.subscribe(data => {
      this.messaggi = data.messaggi;
      this.contatti = data.contatti;

    });
  }
  aggiorna() {

  }
  inviaUno() {
    const iu: InviaMessaggioDto = new InviaMessaggioDto();
    iu.destinatario = this.sessione;
    iu.messaggio = this.messaggio;
    const obse: Observable<RegistrazioneDto> = this.http.post<RegistrazioneDto>
      ('http://localhost:8080/InviaUno09', iu);
    // Creo la callback
    obse.subscribe(risposta => {
      this.messaggi = risposta.messaggi;
      this.contatti = risposta.contatti;
      this.sessione = risposta.sessione;

    });
  }
}

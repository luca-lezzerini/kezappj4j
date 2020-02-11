import { RichiediMessaggiDto } from './richiedi-messaggi-dto';
import { InviaMessaggioDto } from './invia-messaggio-dto';
import { HttpClient } from '@angular/common/http';
import { RichiediRegistrazioneDto } from './richiedi-registrazione-dto';
import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { RegistrazioneDto } from './registrazione-dto';
import { Messaggio } from './messaggio';
import { Chat } from './chat';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  nickName: string;
  messaggio: string;
  righe: string[][] = [['Row1', 'Text', 'Text', 'Text'], ['Row2', 'Text', 'Text', 'Text'], ['Row3', 'Text', 'Text', 'Text']];
  sessione: string;
  messaggi: Messaggio[] = [];
  contatti: Chat[] = [];

  constructor(private http: HttpClient) {

  }

  registrazione() {
    // creo il dto con i dati da inviare
    let dx: RichiediRegistrazioneDto = new RichiediRegistrazioneDto();
    dx.nickname = this.nickName;

    // preparo la richiesta http
    let oss: Observable<RegistrazioneDto> =
      this.http.post<RegistrazioneDto>('http://localhost:8080/registrazione02/', dx);

    // creo la callback
    oss.subscribe(risposta => {
      this.messaggi = risposta.messaggi;
      this.contatti = risposta.contatti;
      this.sessione = risposta.sessione;
    });
  }

  inviaTutti() {

    // se il messaggio non è vuoto
    if (this.messaggio) {
      // creo il dto con i dati da inviare
      let dto: InviaMessaggioDto = new InviaMessaggioDto();
      dto.messaggio = this.messaggio;
      dto.destinatario = null;
      dto.sessione = this.sessione;

      // ripulisce campo messaggio
      this.messaggio = null;

      // preparo la richiesta http
      let oss: Observable<RegistrazioneDto> =
        this.http.post<RegistrazioneDto>('http://localhost:8080/inviaTutti02/', dto);

      // creo la callback
      oss.subscribe(risposta => {
        this.messaggi = risposta.messaggi;
        this.contatti = risposta.contatti;
        this.sessione = risposta.sessione;
      });
    }
  }

  inviaUno(c: Chat) {

    // se il messaggio non è vuoto
    if (this.messaggio) {
      // creo il dto con i dati da inviare
      let dto: InviaMessaggioDto = new InviaMessaggioDto();
      dto.messaggio = this.messaggio;
      dto.destinatario = c.nickname;
      dto.sessione = this.sessione;

      // ripulisce campo messaggio
      this.messaggio = null;

      // preparo la richiesta http
      let oss: Observable<RegistrazioneDto> =
        this.http.post<RegistrazioneDto>('http://localhost:8080/inviaUno02/', dto);

      // creo la callback
      oss.subscribe(risposta => {
        this.messaggi = risposta.messaggi;
        this.contatti = risposta.contatti;
        this.sessione = risposta.sessione;
      });
    }
  }

  aggiorna() {
    // creo il InviaMessaggioDto
    let dto: RichiediMessaggiDto = new RichiediMessaggiDto();
    dto.sessione = this.sessione;
    // preparo la richiesta http
    let oss: Observable<RegistrazioneDto> =
      this.http.post<RegistrazioneDto>('http://localhost:8080/aggiorna02/', dto);

    // creo la callback
    oss.subscribe(risposta => {
      this.messaggi = risposta.messaggi;
      this.contatti = risposta.contatti;
      this.sessione = risposta.sessione;
    });
  }
}

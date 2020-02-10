import { InviaMessaggioDto } from './invia-messaggio-dto';
import { RichiediRegistrazioneDto } from './richiedi-registrazione-dto';
import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Messaggio } from './Messaggio';
import { RegistrazioneDto } from './registrazione-dto';
import { Observable } from 'rxjs';
import { Chat } from './chat';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  nickname: string;
  messaggio: string;
  aggiorna: string;
  righe: string[];
  sessione: string;
  attiva: boolean;
  destinatario: string;

  messaggi: Messaggio[] = [];
  contatti: Chat[] = [];

  constructor(private http: HttpClient) {}

//  InizioSessione(sessione: string) {
//    if (sessione == null) {
//      this.attiva = true;
//    } else {
//      this.attiva = false;
//    }
//  }

  registrazione() {
    let dx : RichiediRegistrazioneDto = new RichiediRegistrazioneDto();
    dx.nickname = this.nickname;

    // preparo la richiesta HTTP
    let oss : Observable<RegistrazioneDto> =
    this.http.post<RegistrazioneDto>('http://localhost:8080/registrazione17', dx);

    // creo la callback
    oss.subscribe(risposta => {
      console.log(risposta);
      this.messaggi = risposta.messaggi;
      this.contatti = risposta.contatti;
      this.sessione = risposta.sessione;
    } );
  }

  inviaATutti() {
    // preparo i dati da inviare al server
    let im : InviaMessaggioDto = new InviaMessaggioDto();
    im.messaggio = this.messaggio;
    im.destinatario = null;
    im.sessione = this.sessione;

    // preparo la richiesta HTTP - invio i dati al server
    let ox : Observable<RegistrazioneDto> =
    this.http.post<RegistrazioneDto>('http://localhost:8080/inviatutti17', im);

    // creo la callback
    ox.subscribe(data => {
      console.log(data);
      this.messaggi = data.messaggi;
      this.contatti = data.contatti;
    } );
  }
}


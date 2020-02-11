import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RegistrazioneDto } from './registrazione-dto';
import { Messaggio } from './messaggio';
import { Chat } from './chat';
import { InviaMessaggioDto } from './invia-messaggio-dto';
import { RichiediMessaggiDto } from './richiedi-messaggi-dto';
import { RichiediRegistrazioneDto } from './richiedi-registrazione-dto';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'MyKezapp';

  nickName: string;
  messaggio: string;
  righe: string[];
  sessione: string;
  messaggi: Messaggio[] = [];
  contatti: Chat[] = [];
  mostra = false;


constructor(private http: HttpClient) { }

  registrazione() {
    this.mostra = true;

    // creo il dto con i dati da inviare
    let dx: RichiediRegistrazioneDto = new RichiediRegistrazioneDto();
    dx.nickname = this.nickName;

   // preparo la richiesta HTTP
    let oss: Observable<RegistrazioneDto> =
      this.http
      .post<RegistrazioneDto>('http://localhost:8080/registrazione08', dx)

   // creo la callback
    oss.subscribe(risposta => {
     console.log(risposta);
     this.messaggi = risposta.messaggi;
     this.contatti = risposta.contatti;
     this.sessione = risposta.sessione;
    });
  }

  inviaATutti() {
    // preparo dati da inviare al server
    let im: InviaMessaggioDto = new InviaMessaggioDto();
    im.messaggio = this.messaggio;
    im.destinatario = null;
    im.sessione = this.sessione;

    // invio i dati al server
    let ox: Observable<RegistrazioneDto> =
      this.http.post<RegistrazioneDto>('http://localhost:8080/inviaTutti08', im);
    ox.subscribe(data => {
      this.messaggi = data.messaggi;
      this.contatti = data.contatti;
    });
  }
/**
 * @description questo metodo recupera da server i dati aggiornati
 */
  aggiorna() {
    // prepara i dati da inviare al server
    let dati: RichiediMessaggiDto = new RichiediMessaggiDto();
    dati.sessione = this.sessione;

    // prepara la richiesta HTTP -> crea observable
    let obs: Observable<RegistrazioneDto>=
      this.http.post<RegistrazioneDto>
      ('http://localhost:8080/aggiorna08', dati);
    // invio la richiesta
    obs.subscribe(rs => {
      this.messaggi = rs.messaggi;
      this.contatti = rs.contatti;
    });
  }

  inviaAUno(c: Chat) {
    // preparo di dati da inviare al server
    let im: InviaMessaggioDto = new InviaMessaggioDto();
    im.messaggio = this.messaggio;
    im.destinatario = c.nickname;
    im.sessione = this.sessione;

    // invio i dati al server
    let ox: Observable<RegistrazioneDto> =
      this.http.post<RegistrazioneDto>('http://localhost:8080/inviaUno08', im);
    ox.subscribe(data => {
      this.messaggi = data.messaggi;
      this.contatti = data.contatti;
    });
  }
}


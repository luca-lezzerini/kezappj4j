import { InviaMessaggioDto } from './InviaMessaggioDto';
import { RichiediMessaggioDto } from './RichiediMessaggioDto';
import { RegistrazioneDto } from './RegistrazioneDto';
import { RichiediRegistrazioneDto } from './RichiediRegistrazioneDto';
import { Component } from '@angular/core';
import { LocationChangeEvent } from '@angular/common';
import { Observable } from 'rxjs';
import { Messaggio } from './Messaggio';
import { Chat } from './Chat';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  nickname: string;
  messaggio: string;
  righe:string[];
  sessione: string;
  // mostraTesto=false;
  contatti: Chat[] = [];
  messaggi: Messaggio[] = [];
  constructor(private http: HttpClient) { }

  registrazione(){
    // this.mostraTesto=true;
    // creo il dto con le variabili da inviare
    let dx : RichiediRegistrazioneDto = new RichiediRegistrazioneDto();
    dx.nickname = this.nickname;
    // indirizzo di destinazione(preparare richiesta http)
    let oss : Observable<RegistrazioneDto> =
    this.http
    .post<RegistrazioneDto>('http://localhost:8080/registrazione07',dx);
    // definisco il passaggio dopo che ha la risposta pronta(callback)
    oss.subscribe(risposta => {
      this.messaggi = risposta.messaggi;
      this.contatti = risposta.contatti;
      this.sessione = risposta.sessione;
    });



  }
  inviaATutti(){
    // preparo i dati da inviare al server
    let im: InviaMessaggioDto = new InviaMessaggioDto();
    im.messaggio = this.messaggio;
    im.sessione = this.sessione;
    im.destinatario = null;
    // invio i dati al server
    let ox : Observable<RegistrazioneDto> =
    this.http
    .post<RegistrazioneDto>('http://localhost:8080/inviaATutti07',im);
    // callback
    ox.subscribe(data => {
      this.messaggi = data.messaggi;
      this.contatti = data.contatti;
    });
  }
}


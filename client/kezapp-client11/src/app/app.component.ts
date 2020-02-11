import { RegistrazioneDto } from './../../../kezapp-client11/src/app/registrazione-dto';
import { RichiediRegistrazioneDto } from './../../../kezapp-client11/src/app/richiedi-registrazione-dto';
import { RichiediMessaggiDto } from './../../../kezapp-client11/src/app/richiedi-messaggi-dto';
import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Messaggio } from '@angular./../../../kezapp-client11/src/app//messaggio';
import { Chat } from '@angular./../../../kezapp-client11/src/app//chat';
import { Observable } from 'rxjs';
import { InviaMessaggioDto } from './invia-messaggio-dto';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  nickName: string;
  messaggio: string;
  righe: string[];
  sessione: string;
  messaggi: Messaggio[] = [];
  contatti: Chat[] = [];
  destinatario: string;

  constructor(private http: HttpClient) { }

  registrazione(){
    // creo il dto con i dati da inviare
    let dx: RichiediRegistrazioneDto = new RichiediRegistrazioneDto();
    dx.nickname = this.nickName;

    // prepararo la richiesta http
    let oss: Observable<RegistrazioneDto> =
    this.http.post<RegistrazioneDto>('http://localhost:8080/registrazione11', dx);

    // creo la callback
    oss.subscribe(risposta => {
        this.messaggi = risposta.messaggi;
        this.contatti = risposta.contatti;
        this.sessione = risposta.sessione;
    });
  }

  inviaATutti(){
    let im: InviaMessaggioDto = new InviaMessaggioDto();
    im.messaggio = this.messaggio;
    im.destinatario = null;
    im.sessione = this.sessione;

    let ox: Observable<RegistrazioneDto> =
    this.http.post<RegistrazioneDto>('http://localhost:8080/inviaTutti11', im);

    ox.subscribe(data => {
      this.messaggi = data.messaggi;
      this.contatti = data.contatti;
  });
}
  /**
   * @description questo metodo recupera i dati aggiornati
   */

  aggiorna(){
    let ag: RichiediMessaggiDto = new RichiediMessaggiDto();
    ag.sessione = this.sessione;

    const obs: Observable<RegistrazioneDto> =
    this.http.post<RegistrazioneDto>('http://localhost:8080/aggiorna11', ag);

    obs.subscribe(rs => {
      this.messaggi = rs.messaggi;
      this.contatti = rs.contatti;
    });
  }

  inviaAUno(c: Chat){
    let im: InviaMessaggioDto = new InviaMessaggioDto();
    im.messaggio = this.messaggio;
    im.destinatario = c.nickname;
    im.sessione = this.sessione;

    let ox: Observable<RegistrazioneDto> =
    this.http.post<RegistrazioneDto>('http://localhost:8080/inviaUno11', im);

    ox.subscribe(data => {
      this.messaggi = data.messaggi;
      this.contatti = data.contatti;
  });
  }
}

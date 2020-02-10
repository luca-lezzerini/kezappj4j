import { RichiediRegistrazioneDto } from './../../../kezapp-client/src/app/richiedi-registrazione-dto';
import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { RegistrazioneDto } from './RegistrazioneDTO';
import { Observable } from 'rxjs';
import { Messaggio } from './Messaggio';
import { Chat } from './chat';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  Nickname: string;
  messaggio: string;
  righe: string[];
  sessione: string;
  messaggi: Messaggio[] = [];
  contatti: Chat [] = [];


constructor(private http: HttpClient) {
}
 registrazione() {
   // creo il dto con i dati da inviare

let dx: RichiediRegistrazioneDto = new RichiediRegistrazioneDto();
dx.nickname = this.Nickname;

// preparo la richiesta http
let oss: Observable<RegistrazioneDto> =
this.http
.post<RegistrazioneDto>('http://localhost:8080/registrazione16', dx);

// creo la callback, decido cosa fare quando c'è la risposta
oss.subscribe(risposta => { // chiamo l'url
  this.messaggi = risposta.messaggi; // quando arriverà la risposta metti messaggi in messaggi, template visualizza nuova tabella
  this.contatti = risposta.contatti;
  });
  }

}

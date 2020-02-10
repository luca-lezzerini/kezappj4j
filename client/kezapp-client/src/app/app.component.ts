import { Observable } from 'rxjs';
import { RichiediRegistrazioneDto } from './../../../kezapp-client02/src/app/richiediRegistrazioneDto';
import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RegistrazioneDto } from './registrazione-dto';
import { Messaggio } from './messaggio';
import { Chat } from './chat';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  nickName: string;
  messaggio: string;
  righe: string[];
  sessione: string;
  messaggi: Messaggio[] = [];
  contatti: Chat[] = [];

  constructor(private http: HttpClient) { }

  registrazione() {
    // creo il dto con i dati da inviare
    let dx: RichiediRegistrazioneDto = new RichiediRegistrazioneDto();
    dx.nickname = this.nickName;

    // preparo la richiesta HTTP
    let oss: Observable<RegistrazioneDto> =
      this.http
        .post<RegistrazioneDto>('http://localhost:8080/registrazione00', dx);

    // creo la callback
    oss.subscribe(risposta => {
      console.log(risposta);
      this.messaggi = risposta.messaggi;
      this.contatti = risposta.contatti;
    });
  }
}


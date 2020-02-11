import { RegistrazioneDto } from './RegistrazioneDto';
import { RichiediRegistrazoneDto } from './RichiediRegistrazioneDto';
import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Messaggio } from './Messaggio';
import { Chat } from './Chat';
import { InviaMessaggio } from './InviaMessaggio';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})

export class AppComponent {
  nickname: string;
  messaggio: string;
  righe: string[];
  sessione: string;
  messaggi: Messaggio[] = [];
  contatti: Chat[] = [];
  sAttiva: boolean;

  constructor(private http: HttpClient) { }

  registrazione() {
    let dx: RichiediRegistrazoneDto = new RichiediRegistrazoneDto();
    dx.nickname = this.nickname;

    // richiesta http
    let oss: Observable<RegistrazioneDto> =
      this.http.post<RegistrazioneDto>('http://localhost:8080/registrazione01', dx);

    // creo la callback
    oss.subscribe(risposta => {
      this.messaggi = risposta.messaggi;
      this.contatti = risposta.contatti;
      this.sessione = risposta.sessione;

      this.sessioneAttiva();
    });
  }

  inviaATutti() {
    let dx: InviaMessaggio = new InviaMessaggio();
    dx.destinatario = null;
    dx.messaggio = this.messaggio;
    dx.sessione = this.sessione;

    // richiesta http
    let oss: Observable<RegistrazioneDto> =
      this.http.post<RegistrazioneDto>('http://localhost:8080/inviaTutti01', dx);

    // creo la callback
    oss.subscribe(risposta => {
      this.messaggi = risposta.messaggi;
      this.contatti = risposta.contatti;
      this.sessione = risposta.sessione;
      console.log('inviato' + risposta);
    });
  }
  invia() {

  }
  aggiorna() {

  }
  sessioneAttiva() {
    if (this.sessione == null) {
      this.sAttiva = false;
    } else {
      this.sAttiva = true;
    }
  }

}

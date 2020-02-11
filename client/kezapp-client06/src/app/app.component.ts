import { InviaMessaggioDto } from './InviaMessaggioDto';
import { RichiediRegistrazioneDto } from './RichiediRegistrazioneDto';
import { RegistrazioneDto } from './RegistrazioneDto';
import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Messaggio } from './Messaggio';
import { Chat } from './Chat';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  nickname: string;
  messaggio: string;
  righe: string[];
  sessione: string;
  messaggi: Messaggio[] = [];
  contatti: Chat[] = [];
  sAttiva: boolean;
  constructor(private http: HttpClient) {}

  registrazione() {
    // creo il dto con i dati da inviare
    let dx: RichiediRegistrazioneDto = new RichiediRegistrazioneDto();
    dx.nickname = this.nickname;

    // preparo la richiesta HTTP
    let oss: Observable<RegistrazioneDto> =
      this.http
        .post<RegistrazioneDto>('http://localhost:8080/registrazione06', dx);

    // creo la callback
    oss.subscribe(risposta => {
      console.log(risposta);
      this.messaggi = risposta.messaggi;
      this.contatti = risposta.contatti;
      this.sessione = risposta.sessione;
      this.sessioneAttiva();
    });
  }

  inviaATutti() {
        // preparo di dati da inviare al server
        let im: InviaMessaggioDto = new InviaMessaggioDto();
        im.messaggio = this.messaggio;
        im.destinatario = null;
        im.sessione = this.sessione;

        // invio i dati al server
        let ox: Observable<RegistrazioneDto> =
          this.http.post<RegistrazioneDto>('http://localhost:8080/invia-tutti06', im);
        ox.subscribe(data => {
          this.messaggi = data.messaggi;
          this.contatti = data.contatti;
        });
  }

  invia() {}
  aggiorna() {}
  sessioneAttiva() {
    if (this.sessione == null) {
      this.sAttiva = false;
    } else {
      this.sAttiva = true;
    }
  }
}

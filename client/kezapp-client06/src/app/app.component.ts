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
    let dx: RichiediRegistrazioneDto = new RichiediRegistrazioneDto();
    dx.nickname = this.nickname;
    // preparare richiesta http
    let oss: Observable<RegistrazioneDto> = this.http.post<RegistrazioneDto>(
      'http://localhost:8080/registrazione06',
      dx
    );
    oss.subscribe(risposta => {
      this.contatti = risposta.contatti;
      this.messaggi = risposta.messaggi;
      this.sessione = risposta.sessione;
      this.sessioneAttiva();
      console.log('Risposta ricevuta' + risposta);
    });
  }

  inviaATutti() {
    let dx: InviaMessaggioDto = new InviaMessaggioDto();
    dx.destinatario = null;
    dx.messaggio = this.messaggio;
    dx.sessione = this.sessione;
    console.log(dx.sessione);
    let oss: Observable<RegistrazioneDto> = this.http.post<RegistrazioneDto>(
      'http://localhost:8080/invia-tutti06',
      dx
    );
    oss.subscribe(risposta => {
      this.contatti = risposta.contatti;
      this.messaggi = risposta.messaggi;
      this.sessioneAttiva();
      console.log('Messaggio inviato ' + dx.messaggio);
      console.log(this.contatti);
      console.log(this.messaggi);
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

import { InviaMessaggioDto } from './classi/inviaMessaggioDto';
import { RichiediRegistrazioneDto } from './classi/richiediRegistrazioneDto';
import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

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
  reg: RichiediRegistrazioneDto;
  send: InviaMessaggioDto;

  constructor(private http: HttpClient) {

  }

  registrazione() {
    this.reg = new RichiediRegistrazioneDto();
    this.reg.nickname = this.nickName;
    this.sessione = this.nickName;
    let obs: Observable<RichiediRegistrazioneDto> = this.http.get<RichiediRegistrazioneDto>('http://localhost:8080/KezappController04')
    obs.subscribe(s => this.sessione = s);
  }

  inviaATutti() {
    this.send = new InviaMessaggioDto();
    this.send.destinatario = null;
    this.send.messaggio = this.messaggio;
    this.send.sessione = this.sessione;
  }

  invia() {

  }

  aggiorna() {

  }

}

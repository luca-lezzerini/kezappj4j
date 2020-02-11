import { Component } from '@angular/core';
import { Chat } from './Chat';
import { Messaggio } from './Messaggio';
import { HttpClient } from '@angular/common/http';
import { RichiediRegistrazioneDto } from './richiedi-registrazione-dto';
import { Observable } from 'rxjs';
import { RegistrazioneDto } from './registrazione-dto';
import { InviaMessaggioDto } from './invia-messaggio-dto';


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

  aggiorna() {
  }
}


import { RichiediMessaggiDto } from './RichiediMessaggiDto';
import { InviaMessaggioDto } from './InviaMessaggioDto';
import { RegistrazioneDto } from './RegistrazioneDto';
import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { RichiediRegistrazioneDto } from './RichiediRegistrazioneDto';
import { Observable, observable } from 'rxjs';
import { Messaggio } from './Messaggio';
import { Chat } from './Chat';

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
  contatti: Chat[]      = [];

  constructor( private http: HttpClient ) { }

  registrazione(){
    
    //creo il dto con i dati da inviare
    let dx: RichiediRegistrazioneDto = new RichiediRegistrazioneDto();
    dx.nickname = this.nickname;

    //preparare la richiesta http
    let oss: Observable<RegistrazioneDto> = this.http.post<RegistrazioneDto>('http://localhost:8080/registrazione10', dx);

    //creo la callback cioe definisco cosa deve fare quando ha la risposta pronta
    oss.subscribe( risposta => {this.messaggi = risposta.messaggi; 
                                this.contatti = risposta.contatti; 
                                this.sessione = risposta.sessione;} )
  }

  inviaATutti(){

    //preparo i dati da inviare al server
    let im: InviaMessaggioDto = new InviaMessaggioDto();
    im.destinatario = null;
    im.sessione = this.sessione;
    im.messaggio = this.messaggio;

    //invio i dati al server
    let ox: Observable<RegistrazioneDto> = this.http.post<RegistrazioneDto>('http://localhost:8080/inviatutti10', im);

    //creo la callback
    ox.subscribe( data => { this.messaggi = data.messaggi;
                                this.contatti = data.contatti;} )
  }

  aggiorna(){

    let x: RichiediMessaggiDto = new RichiediMessaggiDto();
    x.sessione = this.sessione;

    let obs: Observable<RegistrazioneDto> = this.http.post<RegistrazioneDto>('http://localhost:8080/aggiorna10', x)

    obs.subscribe( ricevo => { this.sessione = ricevo.sessione; this.contatti = ricevo.contatti; this.messaggi = ricevo.messaggi; })

    console.log("entrato");
  }

}
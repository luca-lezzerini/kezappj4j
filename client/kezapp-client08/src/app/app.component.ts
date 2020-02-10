import { Component } from '@angular/core';
import { RichiediRegistrazioneDto } from './richiedi-registrazione-dto';
import { HttpClient } from '@angular/common/http';
import { RegistrazioneDto } from './registrazione-dto';
import { Observable } from 'rxjs/internal/Observable';
import { Messaggio } from './messaggio';
import { Chat } from './chat';
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
  sessione: string;
  mostra = false;
  log = [];



  messaggi: Messaggio[] =[];
  contatti: Chat[] = [];


  constructor(private http: HttpClient){

  }

  registrazione() {  // chiama controller in netbeans
    this.mostra = true;
    // creo il dto con i dati da inviare
    let dx : RichiediRegistrazioneDto = new RichiediRegistrazioneDto();
    dx.nickname = this.nickName;   // uzme ga od [(ngmodel)]

    // preparo la richiesta HTTP
    let oss: Observable<RegistrazioneDto> =
    this.http             // il metodo post vuole 2 param : 1.url di servizio e 2.dx
    .post<RegistrazioneDto>('http://localhost:8080/registrazione08', dx);

    // creo la callback
    oss.subscribe( risposta => {
      this.messaggi = risposta.messaggi;  // messagi iz ngfor iz atble u html file
      this.contatti = risposta.contatti;   // sara eseguito  dopo!!! quando arriva la risposta
      this.sessione = risposta.sessione;
    });

  }
//inviaTutti() {
 inviaTutti() {
      // preparp i dati da inviare alserver
      let im: InviaMessaggioDto = new InviaMessaggioDto; // html aggiorna la variabile del ts
      im.messaggio = this.messaggio;
      im.destinatario = null;
      im.sessione = this.sessione;

      //invio i dati al server, param je ono sto vraca controller
      let ox: Observable<RegistrazioneDto> =
          this.http             // il metodo post vuole 2 param : 1.url di servizio e 2.dx
          .post<RegistrazioneDto>('http://localhost:8080/inviaTutti08', im);
      ox.subscribe ( data =>{
            this.messaggi = data.messaggi;
            this.contatti = data.contatti;
          });
  }

  aggiorna() {
  }
}


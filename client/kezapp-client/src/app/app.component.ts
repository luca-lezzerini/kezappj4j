import { Observable } from 'rxjs';
import { RichiediRegistrazioneDto } from './../../../kezapp-client02/src/app/richiediRegistrazioneDto';
import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  nickName: string;
  messaggio: string;
  righe: string [ ];
  sessione: string;

  constructor(private http: HttpClient) { } // singleton
}
registrazione(){
  //  creo il dto con i dati da inviare
  let dx: RichiediRegistrazioneDto = new RichiediRegistrazioneDto ();
  dx.nickname = this.nickname;

  // preparo la richiesta http con un generico observable
  let oss: Observable<>

}

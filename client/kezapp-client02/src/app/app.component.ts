import { HttpClientModule, HttpClient } from '@angular/common/http';
import { RichiediRegistrazioneDto } from './richiediRegistrazioneDto';
import { Component } from '@angular/core';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  nickName: string;
  messaggio: string;
  righe: string[] = [];
  sessione: string;
  rrd: RichiediRegistrazioneDto;
  constructor(private http: HttpClient){

  }
  registrazione() {
    this.rrd.nickname = this.nickName;
    let obs : Observable<RichiediRegistrazioneDto> = this.http.get<RichiediRegistrazioneDto>('http://localhost:8080/KezappController02');
    obs.subscribe();
  }
}

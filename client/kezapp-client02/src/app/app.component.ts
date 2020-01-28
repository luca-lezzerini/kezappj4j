import { HttpClientModule, HttpClient } from '@angular/common/http';
import { RichiediRegistrazioneDto } from './richiediRegistrazioneDto';
import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { RegistrazioneDto } from './registrazioneDto';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  private nickName: string;
  messaggio: string;
  righe: string[][] = [['Row1', 'Text', 'Text', 'Text'], ['Row2', 'Text', 'Text', 'Text'],['Row3', 'Text', 'Text', 'Text']];
  sessione: string = 'ciao';
  rrd: RichiediRegistrazioneDto;
  registrazioneDto: RegistrazioneDto;
  constructor(private http: HttpClient) {

  }
  registrazione() {
    this.rrd.nickname = this.nickName;
    let obs: Observable<RegistrazioneDto> =
      this.http.get<RegistrazioneDto>('http://localhost:8080/KezappController02/${this.rrd.nickname}');
    obs.subscribe(x => this.registrazioneDto = x);
  }
  inviaTutti() {
    let obs: Observable<any> = this.http.get('http://localhost:8080/KezappController02');
    obs.subscribe();
  }
}

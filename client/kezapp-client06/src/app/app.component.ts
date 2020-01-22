import { RichiediRegistrazioneDto } from './richiediRegistrazioneDto';
import { RegistrazioneDto } from './registrazioneDto';
import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  nickname: RichiediRegistrazioneDto;
  messaggio: string;
  righe: string[];
  reg: RegistrazioneDto = new RegistrazioneDto();
  constructor(private http: HttpClient) {}

  registrazione(nickname: RichiediRegistrazioneDto) {
    let reg: Observable<RegistrazioneDto> = this.http.get<RegistrazioneDto>(
      'https://jsonplaceholder.typicode.com/posts'
    );
    reg.subscribe(aa => (this.reg = aa));
  }

  inviaATutti() {}
  invia() {}
  aggiorna() {}
  sessioneAttiva() {
    if (this.reg.sessione == null) {
      return false;
    } else {
      return true;
    }
  }
}

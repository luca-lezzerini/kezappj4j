import { Component } from '@angular/core';
import { METHODS } from 'http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  nickName: string;
  messaggio: string;
  aggiorna: string;
  righe: string[];
  sessione: string;
  attiva: boolean;

  InizioSessione(sessione: string) {
    if (sessione == null) {
      this.attiva = true;
    } else {
      this.attiva = false;
    }
  }
}


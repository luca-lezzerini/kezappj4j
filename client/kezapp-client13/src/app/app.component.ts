import { Component } from '@angular/core';

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


  apparire(sessione: string) {
     if (sessione == null) {
        return true;
     } else {
      return false;
     }

  }


 }


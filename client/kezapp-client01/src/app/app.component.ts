import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  nickname: string;
  messaggio: string;
  righe: string[];
  sessione = "ciao";
  

  registrazione(){

  }
  inviaATutti(){

  }
  invia(){

  }
  aggiorna(){

  }
  sessioneAttiva(sessione:string){
    if(this.sessione== null)
      return false;
      else
      return true;
  }

}

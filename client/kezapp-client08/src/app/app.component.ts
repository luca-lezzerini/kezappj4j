import { Component } from '@angular/core';
import { RigaContatti } from './rigaContatti';
import { RigaMessaggi } from './rigaMessaggi';



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

  rigaContatti: RigaContatti = new RigaContatti();
  righeContatti: RigaContatti[] = [];

  rigaMessaggi: RigaMessaggi = new RigaMessaggi();
  righeMessaggi: RigaMessaggi[] = [];


  registrazione() {
    this.mostra = true;
  }

  inviaATutti() {
  }

  aggiorna() {
  }
}


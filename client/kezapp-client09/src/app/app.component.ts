import { RichiediMessaggioDto } from './richiedimessaggio';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'Kezappclient09';
  nickName: string ;
  messaggio: string ;
  righe: string [];
  sessione: string='aiuto';
  registrazione(RichiediMessaggioDto){

  }
}


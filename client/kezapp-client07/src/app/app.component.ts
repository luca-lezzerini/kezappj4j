import { Component } from '@angular/core';
import { LocationChangeEvent } from '@angular/common';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  nickName: string;
  Messaggio: string;
  righe:string[];
  sessione: string;
  mostraTesto=false;
  
  nascondiTesto(){
    this.mostraTesto=true;
  }
}


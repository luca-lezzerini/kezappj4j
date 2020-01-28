import { Component } from '@angular/core';
import { logging } from 'selenium-webdriver';

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
  mostraTesto: boolean = false;

  nascondiTesto() {
    this.mostraTesto=true
  }

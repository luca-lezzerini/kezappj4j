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
  righe: string[][] = [['Row1','Text','Text','Text'],['Row2','Text','Text','Text'],['Row3','Text','Text','Text'],['Row4','Text','Text','Text']];
  sessione: string;
  mostraTesto: boolean = false;

  nascondiTesto() {
    this.mostraTesto=true
  }
  inviaATutti(){

  }
}
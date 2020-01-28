import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'kezapp-client12';
  nickname :string;
  messaggio :string;
  righe : string[];
  sessione= "ciao";
  colonne : string[];

  sessioneAttiva(sessione: string){
    if(this.sessione==null){
     return false;
    }else{
      return true;
    }
   
    
  }
}

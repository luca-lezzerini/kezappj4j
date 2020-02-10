import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';

@NgModule({ // DECORATORE
  declarations: [
    AppComponent // PROPRIETA' array
  ],
  imports: [ // PROPRIETA' Array
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [], // PROPRIETA' array
  bootstrap: [AppComponent]
})
export class AppModule { }

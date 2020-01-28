import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
//import {MatInputModule, MatTableModule, MatToolbarModule } from '@angular/material';

//@NgModule({
//  imports: [MatToolbarModule, MatInputModule, MatTableModule],
//  exports: [MatToolbarModule, MatInputModule, MatTableModule],
//})
//export class MaterialModule { }


import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

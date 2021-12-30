import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { AddMenuComponent } from './add-menu/add-menu.component'; 

import { AppRoutingModule } from './app-routing.module';

import { HomepageComponent } from './homepage/homepage.component';
import { RestoprofileComponent } from './restoprofile/restoprofile.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    
    AddMenuComponent,
    HomepageComponent,
    RestoprofileComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

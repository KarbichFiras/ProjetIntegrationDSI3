import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { MenuComponent } from './home/menu/menu.component';
import { FooterComponent } from './home/footer/footer.component'; 

import { AppRoutingModule } from './app-routing.module';
import { FoodlayoutComponent } from './home/foodlayout/foodlayout.component'; 
import { AddMenuComponent } from './add-menu/add-menu.component';
import { HomepageComponent } from './homepage/homepage.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    MenuComponent,
    FooterComponent,
    FoodlayoutComponent,
    AddMenuComponent,
    HomepageComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

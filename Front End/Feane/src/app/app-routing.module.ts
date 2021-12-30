import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule , Routes } from '@angular/router';
import { AddMenuComponent } from './add-menu/add-menu.component';
import { HomepageComponent } from './homepage/homepage.component';
import { RestoprofileComponent } from './restoprofile/restoprofile.component';

const routes : Routes =[

  { path: '',   redirectTo: 'homepage', pathMatch: 'full' },
  {path :"addmenu" , component : AddMenuComponent },
  {path :"homepage" , component : HomepageComponent },
  {path :"restoprofile" , component : RestoprofileComponent },
];

@NgModule({
  declarations: [],
  imports: [ RouterModule.forRoot(routes) ],
  exports: [RouterModule]
})
export class AppRoutingModule { }